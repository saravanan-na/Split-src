/**
 * PHR_JavaWebService
 *
 * Copyright (C) 1999-2013 Photon Infotech Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photon.phresco.eshop.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.photon.phresco.eshop.api.EShop;
import com.photon.phresco.eshop.factory.EShopServiceFactory;
import com.photon.phresco.eshop.models.rest.OutputResponse;
import com.photon.phresco.eshop.models.rest.ProductReview;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductReviewResource {

	@POST
	@Path("/post/review")
	@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public OutputResponse postClichedMessage(String review) throws Exception {
	    // Store the message
		System.out.println("Message = " + review);
		Gson gson = new Gson();
		ProductReview productReview = gson.fromJson(review, ProductReview.class);
		EShop shop = EShopServiceFactory.getEShop();
		//JSONObject jsonObject = JSONObject.fromObject(review);
		//System.out.println("jsonObject = " + jsonObject);
		OutputResponse or = shop.postReview(productReview);

		return or;
	}
}