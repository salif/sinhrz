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

package eu.salif.sinhrz.implementations;

import java.nio.file.Path;

public class SinhrzPaths {
	private Path localSinhrzFilePath;
	private Path localLockFilePath;
	private Path remoteLockFilePath;

	public SinhrzPaths(Path localSinhrzFilePath, Path localLockFilePath, Path remoteLockFilePath) {
		setLocalSinhrzFilePath(localSinhrzFilePath);
		setLocalLockFilePath(localLockFilePath);
		setRemoteLockFilePath(remoteLockFilePath);
	}

	public Path getLocalSinhrzFilePath() {
		return localSinhrzFilePath;
	}

	public void setLocalSinhrzFilePath(Path localSinhrzFilePath) {
		this.localSinhrzFilePath = localSinhrzFilePath;
	}

	public Path getLocalLockFilePath() {
		return localLockFilePath;
	}

	public void setLocalLockFilePath(Path localLockFilePath) {
		this.localLockFilePath = localLockFilePath;
	}

	public Path getRemoteLockFilePath() {
		return remoteLockFilePath;
	}

	public void setRemoteLockFilePath(Path remoteLockFilePath) {
		this.remoteLockFilePath = remoteLockFilePath;
	}
}
