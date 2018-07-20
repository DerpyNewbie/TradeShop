/*
 *     Copyright (c) 2016-2017 SparklingComet @ http://shanerx.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *              http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * NOTICE: All modifications made by others to the source code belong
 * to the respective contributor. No contributor should be held liable for
 * any damages of any kind, whether be material or moral, which were
 * caused by their contribution(s) to the project. See the full License for more information
 */

package org.shanerx.tradeshop.enumys;

import com.google.gson.Gson;

import java.io.Serializable;

@SuppressWarnings("unused")
public enum ShopRole implements Serializable {

	OWNER(true, true, true, false),
	MANAGER(false, true, true, false),
	MEMBER(false, false, true, false),
	SHOPPER(false, false, false, true);

	private String roleName;
	private transient boolean destroy, edit, open, shop;

	ShopRole(boolean destroy, boolean edit, boolean open, boolean shop) {
		this.destroy = destroy;
		this.edit = edit;
		this.open = open;
		this.shop = shop;
		roleName = name();
	}

	public boolean canDestroy() {
		return destroy;
	}

	public boolean canEdit() {
		return edit;
	}

	public boolean canOpen() {
		return open;
	}

	public boolean canShop() {
		return shop;
	}

	public static ShopRole deserialize(String serialized) {
		ShopRole shopRole = new Gson().fromJson(serialized, ShopRole.class);
		return shopRole;
	}

	public String serialize() {
		return new Gson().toJson(this);
	}
}