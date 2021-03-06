/*
 * Copyright (C) 2018-2020. Huawei Technologies Co., Ltd. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.utils;

import io.airlift.configuration.Config;
import io.airlift.configuration.ConfigDescription;
import io.airlift.units.Duration;
import io.airlift.units.MinDuration;

import javax.validation.constraints.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * HetuConfig contains Hetu configurations
 *
 * @since 2019-11-29
 */
public class HetuConfig
{
    private Boolean enableFilter = Boolean.FALSE;
    private Long maxIndicesInCache = Long.valueOf(10000000);
    private String filterPlugins;
    private String indexStoreUri = "/opt/hetu/indices/";
    private String indexStoreType = "local";
    private String indexStoreHdfsConfigResources = "/opt/hetu/config/core-site.xml,/opt/hetu/config/hdfs-site.xml";
    private String indexStoreHdfsAuthenticationType = "KERBEROS";
    private String indexStoreHdfsKrb5ConfigPath = "/etc/krb5.conf";
    private String indexStoreHdfsKrb5KeytabPath = "/opt/hetu/config/user.keytab";
    private String indexStoreHdfsKrb5Principal;
    private Boolean enableEmbeddedStateStore = Boolean.FALSE;
    private Boolean enableMultipleCoordinator = Boolean.FALSE;
    private Boolean enableSeedStore = Boolean.FALSE;
    private Duration stateUpdateInterval = new Duration(100, TimeUnit.MILLISECONDS);
    private Duration stateFetchInterval = new Duration(100, TimeUnit.MILLISECONDS);
    private Duration querySubmitTimeout = new Duration(10, TimeUnit.SECONDS);
    private Duration stateExpireTime = new Duration(10, TimeUnit.SECONDS);
    private int dataCenterSplits = 5;
    private Duration dataCenterConsumerTimeout = new Duration(10, TimeUnit.MINUTES);
    private boolean executionPlanCacheEnabled;
    private long executionPlanCacheMaxItems = 1000L;
    private long executionPlanCacheTimeout = 60000L;
    private boolean splitCacheMapEnabled = Boolean.FALSE;
    private Duration splitCacheStateUpdateInterval = new Duration(2, TimeUnit.SECONDS);

    public HetuConfig()
    {
    }

    @NotNull
    public boolean isFilterEnabled()
    {
        return enableFilter;
    }

    @Config("hetu.filter.enabled")
    @ConfigDescription("Is split filter enabled")
    public HetuConfig setFilterEnabled(boolean enabled)
    {
        this.enableFilter = enabled;
        return this;
    }

    @NotNull
    public String getIndexStoreUri()
    {
        return indexStoreUri;
    }

    @Config("hetu.filter.indexstore.uri")
    @ConfigDescription("default indexstore uri")
    public HetuConfig setIndexStoreUri(String indexStoreUri)
    {
        this.indexStoreUri = indexStoreUri;
        return this;
    }

    @NotNull
    public String getIndexStoreType()
    {
        return indexStoreType;
    }

    @Config("hetu.filter.indexstore.type")
    @ConfigDescription("default indexstore type")
    public HetuConfig setIndexStoreType(String indexStoreType)
    {
        this.indexStoreType = indexStoreType;
        return this;
    }

    public Long getMaxIndicesInCache()
    {
        return this.maxIndicesInCache;
    }

    @Config("hetu.filter.cache.max-indices-number")
    @ConfigDescription("The maximum number of indices that could be loaded into cache before eviction happens")
    public HetuConfig setMaxIndicesInCache(Long maxIndicesInCache)
    {
        this.maxIndicesInCache = maxIndicesInCache;
        return this;
    }

    /**
     * Getter for enableEmbeddedStateStore
     *
     * @return if embedded state store is enabled
     */
    public String getIndexStoreHdfsConfigResources()
    {
        return indexStoreHdfsConfigResources;
    }

    @Config("hetu.filter.indexstore.hdfs.config.resources")
    @ConfigDescription("HDFS config resource files, required when hetu.filter.indexstore.type=hdfs")
    public HetuConfig setIndexStoreHdfsConfigResources(String indexStoreHdfsConfigResources)
    {
        this.indexStoreHdfsConfigResources = indexStoreHdfsConfigResources;
        return this;
    }

    public String getIndexStoreHdfsAuthenticationType()
    {
        return indexStoreHdfsAuthenticationType;
    }

    @Config("hetu.filter.indexstore.hdfs.authentication.type")
    @ConfigDescription("HDFS authentication type, supported values are NONE and KERBEROS, required when hetu.filter.indexstore.type=hdfs")
    public HetuConfig setIndexStoreHdfsAuthenticationType(String indexStoreHdfsAuthenticationType)
    {
        this.indexStoreHdfsAuthenticationType = indexStoreHdfsAuthenticationType;
        return this;
    }

    public String getIndexStoreHdfsKrb5ConfigPath()
    {
        return indexStoreHdfsKrb5ConfigPath;
    }

    @Config("hetu.filter.indexstore.hdfs.krb5.conf.path")
    @ConfigDescription("Kerberos config file, required when hetu.filter.indexstore.hdfs.authentication.type=KERBEROS")
    public HetuConfig setIndexStoreHdfsKrb5ConfigPath(String indexStoreHdfsKrb5ConfigPath)
    {
        this.indexStoreHdfsKrb5ConfigPath = indexStoreHdfsKrb5ConfigPath;
        return this;
    }

    public String getIndexStoreHdfsKrb5KeytabPath()
    {
        return indexStoreHdfsKrb5KeytabPath;
    }

    @Config("hetu.filter.indexstore.hdfs.krb5.keytab.path")
    @ConfigDescription("Kerberos keytab file, required when hetu.filter.indexstore.hdfs.authentication.type=KERBEROS")
    public HetuConfig setIndexStoreHdfsKrb5KeytabPath(String indexStoreHdfsKrb5KeytabPath)
    {
        this.indexStoreHdfsKrb5KeytabPath = indexStoreHdfsKrb5KeytabPath;
        return this;
    }

    public String getIndexStoreHdfsKrb5Principal()
    {
        return indexStoreHdfsKrb5Principal;
    }

    @Config("hetu.filter.indexstore.hdfs.krb5.principal")
    @ConfigDescription("Kerberos principal, required when hetu.filter.indexstore.hdfs.authentication.type=KERBEROS")
    public HetuConfig setIndexStoreHdfsKrb5Principal(String indexStoreHdfsKrb5Principal)
    {
        this.indexStoreHdfsKrb5Principal = indexStoreHdfsKrb5Principal;
        return this;
    }

    public String getFilterPlugins()
    {
        return filterPlugins;
    }

    @Config("hetu.filter.plugins")
    @ConfigDescription("Comma separated paths of filter plugin files or directories")
    public HetuConfig setFilterPlugins(String filterPlugins)
    {
        this.filterPlugins = filterPlugins;
        return this;
    }

    public Boolean isEmbeddedStateStoreEnabled()
    {
        return this.enableEmbeddedStateStore;
    }

    @Config("hetu.embedded-state-store.enabled")
    @ConfigDescription("Is embedded state store enabled")
    public HetuConfig setEmbeddedStateStoreEnabled(Boolean enableEmbeddedStateStore)
    {
        this.enableEmbeddedStateStore = enableEmbeddedStateStore;
        return this;
    }

    @Config("hetu.seed-store.enabled")
    @ConfigDescription("Is seed store enabled")
    public HetuConfig setSeedStoreEnabled(Boolean enableSeedStore)
    {
        this.enableSeedStore = enableSeedStore;
        return this;
    }

    @NotNull
    public boolean isSeedStoreEnabled()
    {
        return this.enableSeedStore;
    }

    @NotNull
    public boolean isMultipleCoordinatorEnabled()
    {
        return this.enableMultipleCoordinator;
    }

    @Config("hetu.multiple-coordinator.enabled")
    @ConfigDescription("Is multiple coordinators enabled")
    public HetuConfig setMultipleCoordinatorEnabled(boolean enabled)
    {
        this.enableMultipleCoordinator = enabled;
        return this;
    }

    @NotNull
    @MinDuration("1s")
    public Duration getQuerySubmitTimeout()
    {
        return querySubmitTimeout;
    }

    @Config("hetu.multiple-coordinator.query-submit-timeout")
    @ConfigDescription("Timeout a coordinator allows to try to get a distributed lock to submit new query")
    public HetuConfig setQuerySubmitTimeout(Duration querySubmitTimeout)
    {
        this.querySubmitTimeout = querySubmitTimeout;
        return this;
    }

    @NotNull
    @MinDuration("10ms")
    public Duration getStateUpdateInterval()
    {
        return stateUpdateInterval;
    }

    @Config("hetu.multiple-coordinator.state-update-interval")
    @ConfigDescription("Time interval for updating states to state store")
    public HetuConfig setStateUpdateInterval(Duration stateUpdateInterval)
    {
        this.stateUpdateInterval = stateUpdateInterval;
        return this;
    }

    @NotNull
    @MinDuration("10ms")
    public Duration getStateFetchInterval()
    {
        return stateFetchInterval;
    }

    @Config("hetu.multiple-coordinator.state-fetch-interval")
    @ConfigDescription("Time interval for fetching states from state store")
    public HetuConfig setStateFetchInterval(Duration stateFetchInterval)
    {
        this.stateFetchInterval = stateFetchInterval;
        return this;
    }

    @NotNull
    @MinDuration("5s")
    public Duration getStateExpireTime()
    {
        return stateExpireTime;
    }

    @Config("hetu.multiple-coordinator.state-expire-time")
    @ConfigDescription("Time gap to detect if a state has expired")
    public HetuConfig setStateExpireTime(Duration stateExpireTime)
    {
        this.stateExpireTime = stateExpireTime;
        return this;
    }

    public int getDataCenterSplits()
    {
        return dataCenterSplits;
    }

    @Config("hetu.data.center.split.count")
    @ConfigDescription("Number of splits generated for each data center query results")
    public HetuConfig setDataCenterSplits(int dataCenterSplits)
    {
        this.dataCenterSplits = dataCenterSplits;
        return this;
    }

    public Duration getDataCenterConsumerTimeout()
    {
        return dataCenterConsumerTimeout;
    }

    @Config("hetu.data.center.consumer.timeout")
    @ConfigDescription("Maximum inactive time a data center query can survive without active consumers")
    public HetuConfig setDataCenterConsumerTimeout(Duration dataCenterConsumerTimeout)
    {
        this.dataCenterConsumerTimeout = dataCenterConsumerTimeout;
        return this;
    }

    public boolean isExecutionPlanCacheEnabled()
    {
        return executionPlanCacheEnabled;
    }

    @Config("hetu.executionplan.cache.enabled")
    @ConfigDescription("Enable or disable execution plan cache. Enabled by default.")
    public HetuConfig setExecutionPlanCacheEnabled(boolean executionPlanCacheEnabled)
    {
        this.executionPlanCacheEnabled = executionPlanCacheEnabled;
        return this;
    }

    public long getExecutionPlanCacheMaxItems()
    {
        return executionPlanCacheMaxItems;
    }

    @Config("hetu.executionplan.cache.limit")
    @ConfigDescription("Maximum number of execution plans to keep in the cache")
    public HetuConfig setExecutionPlanCacheMaxItems(long executionPlanCacheMaxItems)
    {
        this.executionPlanCacheMaxItems = executionPlanCacheMaxItems;
        return this;
    }

    public long getExecutionPlanCacheTimeout()
    {
        return executionPlanCacheTimeout;
    }

    @Config("hetu.executionplan.cache.timeout")
    @ConfigDescription("Time in milliseconds to expire cached execution plans after the last access.")
    public HetuConfig setExecutionPlanCacheTimeout(long executionPlanCacheTimeout)
    {
        this.executionPlanCacheTimeout = executionPlanCacheTimeout;
        return this;
    }

    public boolean isSplitCacheMapEnabled()
    {
        return splitCacheMapEnabled;
    }

    @Config("hetu.split-cache-map.enabled")
    @ConfigDescription("Enable or disable split cache map. Disabled by default.")
    public HetuConfig setSplitCacheMapEnabled(boolean splitCacheMapEnabled)
    {
        this.splitCacheMapEnabled = splitCacheMapEnabled;
        return this;
    }

    @MinDuration("10ms")
    public Duration getSplitCacheStateUpdateInterval()
    {
        return splitCacheStateUpdateInterval;
    }

    @Config("hetu.split-cache-map.state-update-interval")
    @ConfigDescription("Time interval for updating split cache map to state store")
    public HetuConfig setSplitCacheStateUpdateInterval(Duration stateUpdateInterval)
    {
        this.splitCacheStateUpdateInterval = stateUpdateInterval;
        return this;
    }
}
