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

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditorFactory {

	public static Editor getEditor() {
		EditorImpl editor = new EditorImpl();
		editor.init();
		return editor;
	}
	
	private static class EditorImpl extends Editor {
		
		public EditorImpl() {
			this.id = Random.nextInt(2147483647) + "mce";
			
			Panel panel = new VerticalPanel();
			TextArea ta = new TextArea();
			
			ta.removeStyleName("gwt-TextArea");
			ta.addStyleName(id);
			
			ta.getElement().setAttribute("id", id);
			ta.getElement().setAttribute("style", "width:100%");
			
			panel.add(ta);
			
			initWidget(ta);
		}
		
		private native void init() /*-{
			$wnd.tinyMCE.init({
				mode: "textareas",
				
				theme: "advanced",
				skin: "o2k7",
				skin_variant: "silver",
				
				plugins: "advlink,spellchecker",
				
				theme_advanced_buttons1: "undo,redo,fontselect,fontsizeselect,bold,italic,underline,forecolor,backcolor,|,link,unlink,|,numlist,bullist,outdent,indent,justifyleft,justifycenter,justifyright,|,removeformat,spellchecker",
				theme_advanced_buttons2: "",
				theme_advacned_buttons3: "",
				theme_advacned_buttons4: "",
				
				theme_advanced_toolbar_location: "top",
				theme_advanced_toolbar_align: "left",
				
				
				editor_selector: this.@net.collegeman.gwt.tinymce.client.Editor::id
			});
		}-*/;
		
		
	}
	
}

