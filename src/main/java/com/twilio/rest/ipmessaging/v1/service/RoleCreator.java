/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.ipmessaging.v1.service;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

public class RoleCreator extends Creator<Role> {
    private final String serviceSid;
    private final String friendlyName;
    private final Role.RoleType type;
    private final List<String> permission;

    /**
     * Construct a new RoleCreator.
     * 
     * @param serviceSid The service_sid
     * @param friendlyName The friendly_name
     * @param type The type
     * @param permission The permission
     */
    public RoleCreator(final String serviceSid, 
                       final String friendlyName, 
                       final Role.RoleType type, 
                       final List<String> permission) {
        this.serviceSid = serviceSid;
        this.friendlyName = friendlyName;
        this.type = type;
        this.permission = permission;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Role
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Role execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            "/v1/Services/" + this.serviceSid + "/Roles",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Role creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Role.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (type != null) {
            request.addPostParam("Type", type.toString());
        }
        
        if (permission != null) {
            for (String prop : permission) {
                request.addPostParam("Permission", prop);
            }
        }
    }
}