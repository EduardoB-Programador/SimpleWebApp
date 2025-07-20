package com.eduardo.util;

public final class StandardTags {
	
	public static final String HEAD_TAGS() {
		return """
				<link rel="preconnect" href="https://fonts.googleapis.com">
				<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
				<link href="https://fonts.googleapis.com/css2?family=Winky+Rough:ital,wght@0,300..900;1,300..900&display=swap" rel="stylesheet">
				<link rel="stylesheet" href="./styles/standard.css"/>
				<meta charset="UTF-8">
				""";
	}
	
	public static final String LOGIN_CONTAINER(String operation, String method, String action, String msg) {		
		String html = """
				<div id="login-container">
					<h1 id="operation-title">?</h1>
					<form method="?" action="?">
						<label>Email</label>
						<input placeholder="email" type="text" class="inputs" name="email"/>
						<label>Password</label>
						<input placeholder="password" type="password" class="inputs" name="password"/>
						<input type="submit" id="submit" value="Submit"/>
						<!>
					</form>
					<span>?</span>
				</div>
				""".replaceFirst("\\?", operation).replaceFirst("\\?", method).replaceFirst("\\?", action);
		
		if (msg != null) 
			html = html.replaceFirst("<\\!>", msg);
		
		if (operation.contains("Sign"))
			return html.replaceFirst("\\?", "If you already have an account click <a id=\"log-sign-in\" href=\"./login.jsp\">here</a> to log in");
		
		return html.replaceFirst("\\?", "If you still don't have an account click <a id=\"log-sign-in\" href=\"./signin.jsp\">here</a> to sign in");
	}
	
	public static enum MessageTypes {
		ERROR_MESSAGE1("<span color=\"red\">?</span>"),
		ERROR_MESSAGE2("<p color=\"red\">?</p>"),
		SUCCESSFUL_MESSAGE1("<span color=\"green\">?</span>"),
		SUCESSFUL_MESSAGE2("<p color=\"green\">?</p>"),
		CUSTOM_MESSAGE("<? ?>?</?>");
		
		private final String tag;
		
		MessageTypes(String tag) {
			this.tag = tag;
		}
		
		public final String insertMessage(String msg) {
			return this.tag.replaceFirst("\\?", msg);
		}
		
		/**<p>Only works on CUSTOM_MESSAGE</p>
		 * 
		 * @param tagName - The tag the message will be within
		 * @param attributes - The attributes of that tag (e.g. class, id, href, src, style, etc.)
		 * @param message - The message within the tag
		 * @return The custom message
		 */
		public final String setCustomAttributes(String tagName, String attributes, String message) {
			if (!this.name().equalsIgnoreCase(CUSTOM_MESSAGE.name()))
				return this.tag;

			String temp = this.tag;
			return temp.replaceFirst("\\?", tagName)
					.replaceFirst("\\?", attributes)
					.replaceFirst("\\?", message)
					.replaceFirst("\\?", tagName);
		}
	}
}
