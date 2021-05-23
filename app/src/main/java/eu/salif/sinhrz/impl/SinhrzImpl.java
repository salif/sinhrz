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
import eu.salif.sinhrz.Sinhrz;

public class SinhrzImpl implements Sinhrz {
	private Args args;
	public SinhrzImpl(Args args) {
		this.setArgs(args);
	}

	public void setArgs(Args args) {
		this.args = args;
	}

	@Override
	public void sync() {
		System.out.printf("Under development%n---%n%s%n%s%n%s%n%s%n%s%n%s%n%b%n",
			this.args.getSinhrzFileName(),
			this.args.getSinhrzLockFileName(),
			this.args.getLocal(),
			this.args.getLocalName(),
			this.args.getRemote(),
			this.args.getRemoteName(),
			this.args.getIsOneWay());
	}
}
