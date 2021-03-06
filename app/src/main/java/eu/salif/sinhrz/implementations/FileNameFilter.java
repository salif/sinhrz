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

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilter implements FilenameFilter {
	private String sinhrzFileName;
	private String lockFileName;

	FileNameFilter(String sinhrzFileName, String lockFileName) {
		setSinhrzFileName(sinhrzFileName);
		setLockFileName(lockFileName);
	}

	public void setSinhrzFileName(String sinhrzFileName) {
		this.sinhrzFileName = sinhrzFileName;
	}

	public void setLockFileName(String lockFileName) {
		this.lockFileName = lockFileName;
	}

	@Override
	public boolean accept(File dir, String name) {
		return !name.equals(sinhrzFileName) && !name.equals(lockFileName);
	}
}
