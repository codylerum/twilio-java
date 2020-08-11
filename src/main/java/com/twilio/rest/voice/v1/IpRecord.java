/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.voice.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpRecord extends Resource {
    private static final long serialVersionUID = 74904859917733L;

    /**
     * Create a IpRecordCreator to execute create.
     *
     * @param ipAddress An IP address in dotted decimal notation, IPv4 only.
     * @return IpRecordCreator capable of executing the create
     */
    public static IpRecordCreator creator(final String ipAddress) {
        return new IpRecordCreator(ipAddress);
    }

    /**
     * Create a IpRecordFetcher to execute fetch.
     *
     * @param pathSid The unique string that identifies the resource
     * @return IpRecordFetcher capable of executing the fetch
     */
    public static IpRecordFetcher fetcher(final String pathSid) {
        return new IpRecordFetcher(pathSid);
    }

    /**
     * Create a IpRecordReader to execute read.
     *
     * @return IpRecordReader capable of executing the read
     */
    public static IpRecordReader reader() {
        return new IpRecordReader();
    }

    /**
     * Create a IpRecordUpdater to execute update.
     *
     * @param pathSid The unique string that identifies the resource
     * @return IpRecordUpdater capable of executing the update
     */
    public static IpRecordUpdater updater(final String pathSid) {
        return new IpRecordUpdater(pathSid);
    }

    /**
     * Create a IpRecordDeleter to execute delete.
     *
     * @param pathSid The unique string that identifies the resource
     * @return IpRecordDeleter capable of executing the delete
     */
    public static IpRecordDeleter deleter(final String pathSid) {
        return new IpRecordDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a IpRecord object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return IpRecord object represented by the provided JSON
     */
    public static IpRecord fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpRecord.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a IpRecord object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return IpRecord object represented by the provided JSON
     */
    public static IpRecord fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpRecord.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String friendlyName;
    private final String ipAddress;
    private final Integer cidrPrefixLength;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private IpRecord(@JsonProperty("account_sid")
                     final String accountSid,
                     @JsonProperty("sid")
                     final String sid,
                     @JsonProperty("friendly_name")
                     final String friendlyName,
                     @JsonProperty("ip_address")
                     final String ipAddress,
                     @JsonProperty("cidr_prefix_length")
                     final Integer cidrPrefixLength,
                     @JsonProperty("date_created")
                     final String dateCreated,
                     @JsonProperty("date_updated")
                     final String dateUpdated,
                     @JsonProperty("url")
                     final URI url) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.ipAddress = ipAddress;
        this.cidrPrefixLength = cidrPrefixLength;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The string that you assigned to describe the resource.
     *
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns An IP address in dotted decimal notation, IPv4 only..
     *
     * @return An IP address in dotted decimal notation, IPv4 only.
     */
    public final String getIpAddress() {
        return this.ipAddress;
    }

    /**
     * Returns An integer representing the length of the
     * [CIDR](https://tools.ietf.org/html/rfc4632) prefix to use with this IP
     * address. By default the entire IP address is used, which for IPv4 is value
     * 32..
     *
     * @return An integer representing the length of the
     *         [CIDR](https://tools.ietf.org/html/rfc4632) prefix to use with this
     *         IP address. By default the entire IP address is used, which for IPv4
     *         is value 32.
     */
    public final Integer getCidrPrefixLength() {
        return this.cidrPrefixLength;
    }

    /**
     * Returns The RFC 2822 date and time in GMT that the resource was created.
     *
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The RFC 2822 date and time in GMT that the resource was last updated.
     *
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the resource.
     *
     * @return The absolute URL of the resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IpRecord other = (IpRecord) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(ipAddress, other.ipAddress) &&
               Objects.equals(cidrPrefixLength, other.cidrPrefixLength) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            sid,
                            friendlyName,
                            ipAddress,
                            cidrPrefixLength,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("sid", sid)
                          .add("friendlyName", friendlyName)
                          .add("ipAddress", ipAddress)
                          .add("cidrPrefixLength", cidrPrefixLength)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}
