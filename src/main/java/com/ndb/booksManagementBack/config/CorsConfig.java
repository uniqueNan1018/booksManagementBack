package com.ndb.booksManagementBack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // すべてのエンドポイントに適用
				.allowedOrigins("http://localhost:3000") // 許可するオリジン
				.allowedMethods("GET", "POST", "PUT", "DELETE") // 許可するHTTPメソッド
				.allowedHeaders("*") // すべてのヘッダーを許可
				.allowCredentials(true); // 認証情報（Cookieなど）を許可
	}
}
