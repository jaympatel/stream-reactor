/*
 * Copyright 2017 Datamountaineer.
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

package com.datamountaineer.streamreactor.connect.rethink.config

import com.datamountaineer.streamreactor.temp.const.TraitConfigConst._

sealed trait ReThinkConfigConstants {
  val RETHINK_CONNECTOR_PREFIX = "connect.rethink"

  val RETHINK_HOST = s"$RETHINK_CONNECTOR_PREFIX.host"
  private[config] val RETHINK_HOST_DOC = "Rethink server host."
  val RETHINK_HOST_DEFAULT = "localhost"
  val RETHINK_DB = s"$RETHINK_CONNECTOR_PREFIX.$DATABASE_PROP_SUFFIX"
  private[config] val RETHINK_DB_DEFAULT = "connect_rethink_sink"
  private[config] val RETHINK_DB_DOC = "The reThink database to read from."
  val RETHINK_PORT = s"$RETHINK_CONNECTOR_PREFIX.port"
  val RETHINK_PORT_DEFAULT = "28015"
  private[config] val RETHINK_PORT_DOC = "Client port of rethink server to connect to."
  val ROUTE_QUERY = s"$RETHINK_CONNECTOR_PREFIX.$KCQL_PROP_SUFFIX"
}

object ReThinkSinkConfigConstants extends ReThinkConfigConstants {
  override private[config] val RETHINK_DB_DOC = "The reThink database to write to and create tables in."

  val CONFLICT_ERROR = "error"
  val CONFLICT_REPLACE = "replace"
  val CONFLICT_UPDATE = "update"

  private[config] val EXPORT_ROUTE_QUERY_DOC = "KCQL expression describing field selection and routes."

  val ERROR_POLICY = s"$RETHINK_CONNECTOR_PREFIX.$ERROR_POLICY_PROP_SUFFIX"
  private[config] val ERROR_POLICY_DOC: String = "Specifies the action to be taken if an error occurs while inserting the data.\n" +
    "There are two available options: \n" + "NOOP - the error is swallowed \n" +
    "THROW - the error is allowed to propagate. \n" +
    "RETRY - The exception causes the Connect framework to retry the message. The number of retries is based on \n" +
    "The error will be logged automatically"
  private[config] val ERROR_POLICY_DEFAULT = "THROW"

  val ERROR_RETRY_INTERVAL = s"$RETHINK_CONNECTOR_PREFIX.$RETRY_INTERVAL_PROP_SUFFIX"
  private[config] val ERROR_RETRY_INTERVAL_DOC = "The time in milliseconds between retries."
  private[config] val ERROR_RETRY_INTERVAL_DEFAULT = "60000"

  val NBR_OF_RETRIES = s"$RETHINK_CONNECTOR_PREFIX.$MAX_RETRIES_PROP_SUFFIX"
  private[config] val NBR_OF_RETRIES_DOC = "The maximum number of times to try the write again."
  private[config] val NBR_OF_RETIRES_DEFAULT = 20

  val BATCH_SIZE = s"$RETHINK_CONNECTOR_PREFIX.$BATCH_SIZE_PROP_SUFFIX"
  private[config] val BATCH_SIZE_DOC = "Per topic the number of sink records to batch together and insert into ReThinkDB."
  private[config] val BATCH_SIZE_DEFAULT = 1000

  val PROGRESS_COUNTER_ENABLED = "connect.progress.enabled"
  val PROGRESS_COUNTER_ENABLED_DOC = "Enables the output for how many records have been processed"
  val PROGRESS_COUNTER_ENABLED_DEFAULT = false
  val PROGRESS_COUNTER_ENABLED_DISPLAY = "Enable progress counter"

  val USERNAME = "connect.rethink.username"
  val USERNAME_DOC = "The user name to connect to rethink with."

  val PASSWORD = "connect.rethink.password"
  val PASSWORD_DOC = "The password for the user."

  val CERT_FILE = "connect.rethink.cert.file"
  val CERT_FILE_DOC = "Certificate file to use for secure TLS connection to the rethinkdb servers. Cannot be used with username/password."
  val CERT_FILE_DEFAULT = ""

  val SSL_ENABLED = "connect.rethink.ssl.enabled"
  val SSL_ENABLED_DOC = "Secure Cassandra driver connection via SSL."
  val SSL_ENABLED_DEFAULT = "false"

  val TRUST_STORE_PATH = "connect.rethink.trust.store.path"
  val TRUST_STORE_PATH_DOC = "Path to the client Trust Store."
  val TRUST_STORE_PASSWD = "connect.rethink.trust.store.password"
  val TRUST_STORE_PASSWD_DOC = "Password for the client Trust Store."
  val TRUST_STORE_TYPE = "connect.rethink.trust.store.type"
  val TRUST_STORE_TYPE_DOC = "Type of the Trust Store, defaults to JKS"
  val TRUST_STORE_TYPE_DEFAULT = "JKS"

  val USE_CLIENT_AUTH = "connect.rethink.ssl.client.cert.auth"
  val USE_CLIENT_AUTH_DEFAULT = "false"
  val USE_CLIENT_AUTH_DOC = "Enable client certification authentication. Requires KeyStore options to be set."

  val KEY_STORE_PATH = "connect.rethink.key.store.path"
  val KEY_STORE_PATH_DOC = "Path to the client Key Store."
  val KEY_STORE_PASSWD = "connect.rethink.key.store.password"
  val KEY_STORE_PASSWD_DOC = "Password for the client Key Store"
  val KEY_STORE_TYPE = "connect.rethink.key.store.type"
  val KEY_STORE_TYPE_DOC = "Type of the Key Store, defauts to JKS"
  val KEY_STORE_TYPE_DEFAULT = "JKS"

  val AUTH_KEY = "connect.rethink.auth.key"
  val AUTH_KEY_DOC = "The authorization key to use in combination with the certificate file."
  val AUTH_KEY_DEFAULT = ""
}

object ReThinkSourceConfigConstants extends ReThinkConfigConstants {
  override private[config] val RETHINK_DB_DOC = "The reThink database to read from."
}
