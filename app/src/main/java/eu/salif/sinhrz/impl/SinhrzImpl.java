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

package eu.salif.sinhrz.impl;

import eu.salif.sinhrz.Args;
import eu.salif.sinhrz.Local;
import eu.salif.sinhrz.Sinhrz;
import eu.salif.sinhrz.SinhrzException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SinhrzImpl implements Sinhrz {
	private Local local;
	private Args args;

	public SinhrzImpl(Local local, Args args) throws SinhrzException {
		this.setLocal(local);
		this.setArgs(args);
	}

	private void setLocal(Local local) {
		this.local = local;
	}

	private void setArgs(Args args) throws SinhrzException {
		this.args = args;
		this.validateArgs();
	}

	private void validateArgs() throws SinhrzException {
		Path localLockFilePath = this.args.getLocalPath().resolve(this.args.getSinhrzLockFileName());
		if (Files.exists(localLockFilePath)) {
			throw new SinhrzException(String.format(this.local.getErrorStringExistsInsideStringMessage(),
				this.args.getSinhrzLockFileName(),
				this.args.getLocalName()));
		}
		Path remoteLockFilePath = this.args.getRemotePath().resolve(this.args.getSinhrzLockFileName());
		if (Files.exists(remoteLockFilePath)) {
			throw new SinhrzException(String.format(this.local.getErrorStringExistsInsideStringMessage(),
				this.args.getSinhrzLockFileName(),
				this.args.getRemoteName()));
		}
		Path sinhrzFilePath = this.args.getLocalPath().resolve(this.args.getSinhrzFileName());
		if (!Files.exists(sinhrzFilePath)) {
			if (this.args.getInit()) {
				try {
					Files.createFile(sinhrzFilePath);
				} catch (IOException e) {
					throw new SinhrzException(String.format(this.local.getErrorStringCanNotBeCreatedMessage(),
						sinhrzFilePath));
				}
			}
			else {
				throw new SinhrzException(String.format(this.local.getErrorStringDoesNotExistsInsideStringMessage(),
					this.args.getSinhrzFileName(), this.args.getLocalName()));
			}
		}
	}

	@Override
	public void sync() throws SinhrzException {
		throw new SinhrzException(String.format(this.local.getErrorUnsupportedMessage(), "sync"));
	}
}
