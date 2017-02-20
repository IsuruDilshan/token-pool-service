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

import com.wso2telco.dep.tpservice.model.TokenDTO;
import com.wso2telco.dep.tpservice.util.exception.TokenException;

public interface TokenControllable {
	        TokenDTO refreshToken(final TokenDTO token) throws TokenException ;
	        void removeToken(final TokenDTO token) throws TokenException ;
	        void removeToken(final String token) throws TokenException ;
	    	TokenDTO refreshToken(final String token) throws TokenException ;
	    	void init() throws TokenException ;
			void stop()throws TokenException ;
			TokenDTO getToken()throws TokenException ;
			void accqureToken() throws TokenException ;
			void shedule() throws TokenException;
		//	void executeShedule() throws TokenException;

}
