package com.patriotdevelopment.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091000479654";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4Jbav1C607mWHMayqg/zpWaUzO4BiLzr9Km6IMZGnDf9Fh5uoJ1jJWd7HVr57FAOi8n5omkarXZciVi9Nvi4JHIQDV8xj3kGP/2HKsgXeC88jKoFdawZut73UEekmb1vFjQMYB1IfgcfcpmfaCF8zbqkAw+DOjHjOuJuGbl5838tJT3Pj/I8CrDx+v2bpr7kzGlVWAbf8y3WmpMBMrd05Wwfkackw1dR3rxJMiC6FiigsrWuNdhz5RpLieUXLAhSkExnp9WnmAHjkZ2RqlUUjBXdtkB6a0DqZLyRDw64UisiIebpreIa14EEmzQOfGemFS6s+Nz4lRiweiSnfGhHJAgMBAAECggEBAKQTpnWAX6WDDR+q2SiNthnNcG73w2q4npzY4+eiEx+AT0WKkN0BQhEWbHO9DLfpm1vjKVLWs8UY/QLxO/DPVYF00QORhWIutMgzStUqTiQM7aFtzBqKtA6O1StSUiWW73RUMr+ENl4wav5lnv8cmobfQOKXpYUkkLfQsXLUgIhN865SsYG8c26Ja+2NkGS8CqoisEBin1WAA2NTx2jGLvXR6snYmjS12A2Wfs4OlM53/Iu8DNOtx5sVWHkVx8KALvMlitWfrUi3LeHYyAN1YDG4p1h0jJZ8gpCh2XTqryURAdkYGmly3p5VU2uDMT364nI023hAHIyUck/wvZreI2kCgYEA6DqyPJ/jBT+gJbghozB0uqurSFezEVimWBy7BkkFA6CIZ9n5F2WYK/xK2hT21v+xDIYs7UIuINoqqEHyPhFn8tIPK4Yo04CKNAVUzFi2AkkJbiUdcnEOEpF3D4PS26oD76xxWWfyliD42kpBmL+q0elmZC6VQTpSFPihIW7Kw9MCgYEAyv8VlYU4Vcfdq0RO4P1q3sv57QC/6uHW9A0jjqmqllQjk+FtErW7kEjk3v//qoitOnZjoGTj0nO73WBuncVed9ZuqhlvcNdWzEe+Dagfp7APlZNGU/qC8W05g6T1/GzAzvo9ISq+58O3dZaOOE1tooZWjZhPgO9VR7HmmxOtPnMCgYAkC1g2yKo32lRFBntSFOdJQfPn2pTUkGnhKzRsGVFJ6tTBKbfbxc0EprgHeVGGtVEJnJnEiY0XVEVisDmlIJZ9vdTU8JHNohnRUTKENRCq8iMgkWospReGEkXkhpVnus+5l45QTi3810lIuFXOG5Gr2wolaoWIBkFPN/fqdIPMOQKBgFh4B14cq0qnSnJj2MSxbSwgVZH2661gM6A1QbPhOdk+XisK6dBnp5DgU+7kPvaBjo2WHyE+FxQXIF8AsfTMmbk8mQpE/458KvXopmmpRfJ9Bq23e8UJvpudcJ1w/Uu/0d/iq1WTHZRAdeonbWAYTpmwVnRrVuroY5BVdh1L3AsFAoGBAIiNEp6fZ8YUh3GBI/sS1uvlr+wjHq03JfublQ76chSuPBja9mAcx23vu4wZgRePY5/Vj6cSkf/JaMyWsy+kqunj0OM34gEglMLo8X7AdCBjYubWYuwQ23ATrp5GGhSMcZuOyIvKF5BZvD2cR4gN3NP9YfTNw7jB8c7P76jYCb3S";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1arTJJVhyIgko9Zt+i5/VzyVGanpqHX/LCh2O+7Uridmzh3AeI2bAk4ijSp2ojAC2Yj9NSr2TvqaroBwLXCdfdrn/G9NSTzw/+OGdDb12WWQS9jzMRNMuSgmkhh4Y8I2eU9g2NZKdV+ZIK2KGB9Exw2mn5fq4ThhVux/rmhWASOGJ+fS36ykgqiYAp40unwsM76vXEeA1/cSAjFxXHXOXKJf50Pj3iedoV6rdQrFZG7inpG+gbwQdwMZJ1F/tpIXmCkDsH/0tuH8tgm6kI87kJ7mdfrOegTRq68zarOjIClYpJkG0yBnGf+xDEvkFtiu8V4tTm6G0rkxwTeeA7a7uQIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://mjxy.tunnel.qydev.com/callback/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://mjxy.tunnel.qydev.com/callback/return";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
