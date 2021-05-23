/*
 * Copyright 2021 Salif Mehmed
 *
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

package eu.salif.sinhrz;

public final class Const {

	private static final String SINHRZ_EXT = ".sinhrz";

	public static final String ENV_SINHRZ_FILE = "SINHRZ_FILE";
	public static final String DEFAULT_SINHRZ_FILE = SINHRZ_EXT;

	public static final String ENV_SINHRZ_LOCK_FILE = "SINHRZ_LOCK_FILE";
	public static final String DEFAULT_SINHRZ_LOCK_FILE = ".lock" + SINHRZ_EXT;

	public static final String ENV_LOCAL = "SINHRZ_LOCAL";
	public static final String DEFAULT_LOCAL = "";

	public static final String ENV_LOCAL_NAME = "SINHRZ_LOCAL_NAME";
	public static final String DEFAULT_LOCAL_NAME = "local";

	public static final String ENV_REMOTE = "SINHRZ_REMOTE";
	public static final String DEFAULT_REMOTE = "";

	public static final String ENV_REMOTE_NAME = "SINHRZ_REMOTE_NAME";
	public static final String DEFAULT_REMOTE_NAME = "remote";

	public static final String ENV_ONE_WAY = "SINHRZ_ONE_WAY";
}
