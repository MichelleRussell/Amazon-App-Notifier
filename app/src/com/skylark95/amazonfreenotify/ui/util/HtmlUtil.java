package com.skylark95.amazonfreenotify.ui.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

public class HtmlUtil {

	private HtmlUtil() {
	}

	public static void createHtmlView(Context context, TextView textView, InputStream in) throws IOException {
		String html = CharStreams.toString(new InputStreamReader(in, Charsets.UTF_8));
		html = Jsoup.clean(html, Whitelist.basic());
		textView.setText(Html.fromHtml(html));
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		textView.setTextColor(context.getResources().getColor(android.R.color.secondary_text_dark_nodisable));
	}


}