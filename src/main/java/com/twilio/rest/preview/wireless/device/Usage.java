/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.preview.wireless.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usage extends Resource {
    private static final long serialVersionUID = 66736340742112L;

    /**
     * Create a UsageFetcher to execute fetch.
     * 
     * @param deviceSid The device_sid
     * @return UsageFetcher capable of executing the fetch
     */
    public static UsageFetcher fetch(final String deviceSid) {
        return new UsageFetcher(deviceSid);
    }

    /**
     * Converts a JSON String into a Usage object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Usage object represented by the provided JSON
     */
    public static Usage fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Usage.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Usage object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Usage object represented by the provided JSON
     */
    public static Usage fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Usage.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String deviceSid;
    private final String deviceAlias;
    private final String accountSid;
    private final Map<String, Object> period;
    private final Map<String, Object> commandsUsage;
    private final Map<String, Object> commandsCosts;
    private final Map<String, Object> dataUsage;
    private final Map<String, Object> dataCosts;
    private final URI url;

    @JsonCreator
    private Usage(@JsonProperty("device_sid")
                  final String deviceSid, 
                  @JsonProperty("device_alias")
                  final String deviceAlias, 
                  @JsonProperty("account_sid")
                  final String accountSid, 
                  @JsonProperty("period")
                  final Map<String, Object> period, 
                  @JsonProperty("commands_usage")
                  final Map<String, Object> commandsUsage, 
                  @JsonProperty("commands_costs")
                  final Map<String, Object> commandsCosts, 
                  @JsonProperty("data_usage")
                  final Map<String, Object> dataUsage, 
                  @JsonProperty("data_costs")
                  final Map<String, Object> dataCosts, 
                  @JsonProperty("url")
                  final URI url) {
        this.deviceSid = deviceSid;
        this.deviceAlias = deviceAlias;
        this.accountSid = accountSid;
        this.period = period;
        this.commandsUsage = commandsUsage;
        this.commandsCosts = commandsCosts;
        this.dataUsage = dataUsage;
        this.dataCosts = dataCosts;
        this.url = url;
    }

    /**
     * Returns The The device_sid.
     * 
     * @return The device_sid
     */
    public final String getDeviceSid() {
        return this.deviceSid;
    }

    /**
     * Returns The The device_alias.
     * 
     * @return The device_alias
     */
    public final String getDeviceAlias() {
        return this.deviceAlias;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The period.
     * 
     * @return The period
     */
    public final Map<String, Object> getPeriod() {
        return this.period;
    }

    /**
     * Returns The The commands_usage.
     * 
     * @return The commands_usage
     */
    public final Map<String, Object> getCommandsUsage() {
        return this.commandsUsage;
    }

    /**
     * Returns The The commands_costs.
     * 
     * @return The commands_costs
     */
    public final Map<String, Object> getCommandsCosts() {
        return this.commandsCosts;
    }

    /**
     * Returns The The data_usage.
     * 
     * @return The data_usage
     */
    public final Map<String, Object> getDataUsage() {
        return this.dataUsage;
    }

    /**
     * Returns The The data_costs.
     * 
     * @return The data_costs
     */
    public final Map<String, Object> getDataCosts() {
        return this.dataCosts;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
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
        
        Usage other = (Usage) o;
        
        return Objects.equals(deviceSid, other.deviceSid) && 
               Objects.equals(deviceAlias, other.deviceAlias) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(period, other.period) && 
               Objects.equals(commandsUsage, other.commandsUsage) && 
               Objects.equals(commandsCosts, other.commandsCosts) && 
               Objects.equals(dataUsage, other.dataUsage) && 
               Objects.equals(dataCosts, other.dataCosts) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceSid,
                            deviceAlias,
                            accountSid,
                            period,
                            commandsUsage,
                            commandsCosts,
                            dataUsage,
                            dataCosts,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("deviceSid", deviceSid)
                          .add("deviceAlias", deviceAlias)
                          .add("accountSid", accountSid)
                          .add("period", period)
                          .add("commandsUsage", commandsUsage)
                          .add("commandsCosts", commandsCosts)
                          .add("dataUsage", dataUsage)
                          .add("dataCosts", dataCosts)
                          .add("url", url)
                          .toString();
    }
}