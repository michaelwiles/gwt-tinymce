/*
 * This class is part of the "gwt-tinymce" library.  
 * Copyright (C)2008 Collegeman.net, LLC.  
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package net.collegeman.gwt.tinymce.client;

import com.google.gwt.user.client.ui.Composite;

public abstract class Editor extends Composite {
	
	private boolean active = false;
	
	protected String id;
	
	public final void toggleEditor() {
		execCommand(!active ? "mceAddControl" : "mceRemoveControl", false, id);
		active = !active;
	}
	
	public final native void execCommand(String c, boolean b, String v) /*-{
		$wnd.tinyMCE.execCommand(c, b, v);
	}-*/;
	
	public String getId() {
		return id;
	}

}
