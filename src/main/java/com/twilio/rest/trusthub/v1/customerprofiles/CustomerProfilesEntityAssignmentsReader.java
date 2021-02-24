/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trusthub.v1.customerprofiles;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class CustomerProfilesEntityAssignmentsReader extends Reader<CustomerProfilesEntityAssignments> {
    private final String pathCustomerProfileSid;

    /**
     * Construct a new CustomerProfilesEntityAssignmentsReader.
     *
     * @param pathCustomerProfileSid The unique string that identifies the resource.
     */
    public CustomerProfilesEntityAssignmentsReader(final String pathCustomerProfileSid) {
        this.pathCustomerProfileSid = pathCustomerProfileSid;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return CustomerProfilesEntityAssignments ResourceSet
     */
    @Override
    public ResourceSet<CustomerProfilesEntityAssignments> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return CustomerProfilesEntityAssignments ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<CustomerProfilesEntityAssignments> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TRUSTHUB.toString(),
            "/v1/CustomerProfiles/" + this.pathCustomerProfileSid + "/EntityAssignments"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return CustomerProfilesEntityAssignments ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<CustomerProfilesEntityAssignments> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<CustomerProfilesEntityAssignments> nextPage(final Page<CustomerProfilesEntityAssignments> page,
                                                            final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<CustomerProfilesEntityAssignments> previousPage(final Page<CustomerProfilesEntityAssignments> page,
                                                                final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of CustomerProfilesEntityAssignments Resources for a given
     * request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<CustomerProfilesEntityAssignments> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CustomerProfilesEntityAssignments read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "results",
            response.getContent(),
            CustomerProfilesEntityAssignments.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}