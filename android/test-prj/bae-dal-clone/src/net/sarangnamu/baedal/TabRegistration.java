/* 
 * Copyright (c) 2003-2011, cheol-dong choi, twitter @aucd29
 * 
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions: 
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE. 
 *  
 */
 
 package net.sarangnamu.baedal;

import net.sarangnamu.baedal.config.ConfigBaedal;
import net.sarangnamu.utils.EventImageButtonList;
import android.app.Activity;
import android.os.Bundle;

public class TabRegistration extends Activity {
	private EventImageButtonList btnlist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabregistration);
		
		btnlist = new EventImageButtonList(this);
		btnlist.setLayout(R.id.registrationLayout);
		btnlist.addImageView(R.drawable.reg_top);
		btnlist.addButtonWithBrowser(R.drawable.reg_menu01, ConfigBaedal.REGISTRATION);
		btnlist.addSeperator(R.drawable.main_line);		
		btnlist.addButtonWithBrowser(R.drawable.reg_menu02, ConfigBaedal.REGISTRATION_CAFE);
		btnlist.addButtonWithBrowser(R.drawable.reg_menu03, ConfigBaedal.MAIL_URI);
		btnlist.addButtonWithBrowser(R.drawable.reg_menu04, ConfigBaedal.POST_URI);
	}
}
