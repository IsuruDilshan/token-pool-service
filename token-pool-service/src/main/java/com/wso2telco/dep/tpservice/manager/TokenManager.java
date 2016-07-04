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

package com.wso2telco.dep.tpservice.manager;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.wso2telco.dep.tpservice.dao.TokenDAO;
import com.wso2telco.dep.tpservice.model.TokenDTO;
import com.wso2telco.dep.tpservice.model.WhoDTO;
import com.wso2telco.dep.tpservice.util.Validator;
import com.wso2telco.dep.tpservice.util.exception.BusinessException;
import com.wso2telco.dep.tpservice.util.exception.GenaralError;
import com.wso2telco.dep.tpservice.util.exception.TokenException;

public class TokenManager {

	private static Logger log = LoggerFactory.getLogger(TokenManager.class);

	/**
	 * Get all valid tokens for given owner id
	 * @return ArrayList of TokenDTO
	 * @throws Exception, return when an error is occurred.
	 */
	public List<TokenDTO> getAllTokensForOwner(String ownerId) throws BusinessException {
		List<TokenDTO> tokenList = null;
		if (Validator.isInvalidString(ownerId)) {
			log.debug("owner id cannot be null or empty");
			throw new BusinessException(GenaralError.INPUT_PARAMETER_ERROR);
        }
		try {
			TokenDAO tokenDAO = new TokenDAO();
			tokenList = tokenDAO.getAllTokensForOwner(ownerId);
		} catch (Exception e) {
			log.error("getAllOwners() failed ", e);
			throw new BusinessException(GenaralError.INTERNAL_SERVER_ERROR);
		}
		return tokenList;
	}
	
	/**
	 * Get all valid tokens for given owner id JSON
	 * @return JSONObject {"tokens":[]}
	 * @throws Exception, return when an error is occurred.
	 */
	public JSONObject getAllTokensForOwnerJSON(String ownerId) throws BusinessException {
		ArrayList<TokenDTO> tokenList = null;
		if (Validator.isInvalidString(ownerId)) {
			log.debug("owner id cannot be null or empty");
			throw new BusinessException(GenaralError.INPUT_PARAMETER_ERROR);
        }
		JSONObject result = new JSONObject();
		try {
			//get list of objects
			TokenDAO tokenDAO = new TokenDAO();
			tokenList = tokenDAO.getAllTokensForOwner(ownerId);
			
			//get json string from list
			Gson gson = new Gson();
		    String jsonString = gson.toJson(tokenList);
		    
		    //convert to json array and set to result object
		    JSONArray resultObject = new JSONArray(jsonString);
			result.put("tokens", resultObject);
		} catch (Exception e) {
			log.error("getAllTokensForOwnerJSON() failed ", e);
			throw new BusinessException(GenaralError.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	public void invalidate(final WhoDTO whoDTO ,final TokenDTO tokenDto)throws TokenException {
		log.debug("InValidating the token "+whoDTO+ " token "+tokenDto );
	}
	
	public void saveToken(final WhoDTO whoDTO ,final TokenDTO tokenDto)throws TokenException {
		log.debug("save the token "+whoDTO+ " token "+tokenDto );
	}
	
	public TokenDTO loadNewChild (final WhoDTO whoDTO ,final TokenDTO tokenDto)throws TokenException {
		return null;
	}
}