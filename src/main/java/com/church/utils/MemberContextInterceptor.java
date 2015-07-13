package com.church.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;


public class MemberContextInterceptor extends HandlerInterceptorAdapter{

//	private Logger LOG = Logger.getLogger(MemberContextInterceptor.class);

	public static final String USER_SESSION = "user";
	
	public final static String SESSION_KEY = "sessionuserkey";
	
	/**登录页面相关的常量*/
//	public static final String PROCESS_URL = "processUrl";
	public static final String RETURN_URL = "returnUrl";
			
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		//在用户超时退出的时候记录日志，以备跟踪和分析问题
//		SessionTimeOutDto logInfo = new SessionTimeOutDto(cs==null?null:cs.getUserId(), sessionId, RequestUtils.getLocation(request));
		String uri = getURI(request);
		// 不在验证的范围内
		if (exclude(uri)) {
			return true;
		}
		
		SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(SESSION_KEY);
		
		if(sessionUser!=null){
			request.setAttribute("sessionUser", sessionUser);
			return true;
		}

		if(isAjaxRequest(request)){
			response.addHeader("sessionstate", "timeout");
			return false;
		}
		
		response.sendRedirect(getLoginUrl(request));
		return false;
	}
	
	
	private String getLoginUrl(HttpServletRequest request) throws UnsupportedEncodingException {
		StringBuilder buff = new StringBuilder();
		if (loginUrl.startsWith("/")) {
			String ctx = request.getContextPath();
			if (!StringUtils.isBlank(ctx)) {
				buff.append(ctx);
			}
		}
		
		String returnUrl = request.getParameter("returnUrl");
		
		buff.append(loginUrl).append("?");
		if(returnUrl==null || "".equals(returnUrl)){
			buff.append(RETURN_URL).append("=").append(encode(getLocation(request)));
		}else{
			buff.append(RETURN_URL).append("=").append(encode(returnUrl));
		}
		
//		if (!StringUtils.isBlank(processUrl)) {
//			buff.append("&").append(PROCESS_URL).append("=").append(
//					getProcessUrl(request));
//		}
		return buff.toString();
	}
	
	public String encode(String url) {
		String str=url;
		if(StringUtils.isBlank(str)){
			return str;
		}
		try {
			str = java.net.URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 获得当的访问路径
	 * 
	 * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
	 * 
	 * @param request
	 * @return
	 */
	public static String getLocation(HttpServletRequest request) {
		UrlPathHelper helper = new UrlPathHelper();
		StringBuffer buff = request.getRequestURL();
		String uri = request.getRequestURI();
		String origUri = helper.getOriginatingRequestUri(request);
		buff.replace(buff.length() - uri.length(), buff.length(), origUri);
		String queryString = helper.getOriginatingQueryString(request);
		if (queryString != null) {
			buff.append("?").append(queryString);
		}
		return buff.toString();
	}
	
	private boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)){
			return true;
		}else{
			return false;
		}
	}
	
//	private boolean isHtml(HttpServletRequest request) {
//		String acceptType = request.getHeader("Accept");
//		if(acceptType.indexOf("text/html")!=-1){
//			return true;
//		}else{
//			return false;
//		}
//	}

//	private String getProcessUrl(HttpServletRequest request) {
//		StringBuilder buff = new StringBuilder();
//		if (loginUrl.startsWith("/")) {
//			String ctx = request.getContextPath();
//			if (!StringUtils.isBlank(ctx)) {
//				buff.append(ctx);
//			}
//		}
//		buff.append(processUrl);
//		return buff.toString();
//	}
	
	private boolean exclude(String uri) {
		//System.out.println(JSON.toJSONString(excludeUrls));
		if (excludeUrls != null) {
			for (String exc : excludeUrls) {
				if (exc.equals(uri)) {
					return true;
				}else if(exc.endsWith("*") && uri.startsWith(exc.substring(0,exc.length()-1))){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 获得第三个路径分隔符的位置
	 * 
	 * @param request
	 * @throws IllegalStateException
	 *             访问路径错误，没有三(四)个'/'
	 */
	private static String getURI(HttpServletRequest request)
			throws IllegalStateException {
		UrlPathHelper helper = new UrlPathHelper();
		String uri = helper.getOriginatingRequestUri(request);
		String ctxPath = helper.getOriginatingContextPath(request);
		if (!StringUtils.isBlank(ctxPath)) {
			int start = uri.indexOf('/', 1);
			uri=uri.substring(start);
		}
		//System.out.println("uri:"+uri);
		return uri;
	}
	
/*	protected void sendError(HttpServletRequest request, HttpServletResponse response, String errorCode) throws IOException{
		String msg = FrontUtils.getMessage(request, errorCode);
		response.addHeader("parox_error", URLEncoder.encode(msg, "utf-8"));
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorCode);
	}*/
	
	private String loginUrl;
//	private String processUrl;
	private String returnUrl;
	
//	private boolean auth = true;
	private String[] excludeUrls;
	
	
	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

//	public String getProcessUrl() {
//		return processUrl;
//	}
//
//	public void setProcessUrl(String processUrl) {
//		this.processUrl = processUrl;
//	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

//	public boolean isAuth() {
//		return auth;
//	}
//
//	public void setAuth(boolean auth) {
//		this.auth = auth;
//	}

	public String[] getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(String[] excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	}