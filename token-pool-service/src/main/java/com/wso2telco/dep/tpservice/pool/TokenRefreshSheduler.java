/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wso2telco.dep.tpservice.pool;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wso2telco.dep.tpservice.model.TokenDTO;
import com.wso2telco.dep.tpservice.model.WhoDTO;
import com.wso2telco.dep.tpservice.util.exception.BusinessException;

/**
 * Schedule the token expire service.
 *
 *
 */
class TokenRefreshSheduler {
	Logger log = LoggerFactory.getLogger(TokenRefreshSheduler.class);

	public void shedule(final TokenDTO tokenDTO, final WhoDTO whoDTO) throws BusinessException {
		/**
		 * the seducer trigger monitoring service before the token expires
		 * trigges two times early the default connection reset.
		 */
		final long tokenExpiory = (tokenDTO.getCreatedOn() + tokenDTO.getTokenValidity())
				- 2 * whoDTO.getDefaultConnectionRestTime();

		try {
			Timer timer = new Timer();
			//Schedule the re - generate process
			timer.schedule(new TimerTask() {

										@Override
										public void run() {
							
											try {
												TokenPool.getInstance().removeToken(tokenDTO.getTokenId());
												
												//thread sleep for 2* default connection reset time
												Thread.sleep(2 * whoDTO.getDefaultConnectionRestTime());
												
												new TokenReGenarator().reGenarate(whoDTO, tokenDTO);
												
												
											} catch (BusinessException | InterruptedException e) {
												log.error(" ERROR occured at token regenarate process at tak sheduler ",e);
											}
							
										}
									}, tokenExpiory);
		} catch (IllegalArgumentException  e) {
			/**
			 * Schedule time already expired
			 */
			log.error(" token already expired tokenID :"+tokenDTO.getTokenId()+ " | owner id :"+ whoDTO.getId());
			new TokenReGenarator().reGenarate(whoDTO, tokenDTO);
		}

	}

}