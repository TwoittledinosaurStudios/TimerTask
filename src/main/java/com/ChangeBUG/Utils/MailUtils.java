package com.ChangeBUG.Utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailUtils {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    public static void main(String[] args) throws Exception{
//        //获取开始时间
//        double start = System.currentTimeMillis();
//        boolean zhi = mailOccurs(
//                "2028744995@qq.com",
//                "mslkykbjaimceeff",
//                "2028744995@qq.com",
//                "任务 每日 汇报",
//                "完成非常不错",
//                "false"
//        );
//        //获取结束时间
//        double end = System.currentTimeMillis();
//        double time = (end - start) / 1000;
//
//        if (zhi) {
//            System.out.println("执行成功 -- 程序运行时间: " + time + " 秒");
//        } else {
//            System.out.println("执行失败 -- 程序运行时间: " + time + " 秒");
//        }
    }

    /**
     * 电子邮箱 发送
     *
     * @param addresser      发件人电子邮箱
     * @param addreCode      授权码
     * @param addressee      收件人电子邮箱
     * @param emailSubject   设置邮件主题头
     * @param contentOfEmail 开启Debug调试
     * @param debug          设置邮件内容
     * @return 是否执行成功
     */
    public static boolean mailOccurs(String addresser, String addreCode, String addressee, String emailSubject, String contentOfEmail, String debug) {

        boolean zhi = true;

        try {
            // 获取系统属性
            Properties properties = System.getProperties();
            // 开启Debug调试
            properties.setProperty("mail.debug", debug);
            // 发送服务器需要身份验证
            properties.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", "smtp.qq.com");
            // 端口号
            // properties.setProperty("mail.smtp.port", "465");
            // 发送邮件协议
            properties.setProperty("mail.transport.protocol", "smtp");
            //开启ssl加密（并不是所有的邮箱服务器都需要，但是qq邮箱服务器是必须的）
            MailSSLSocketFactory msf = new MailSSLSocketFactory();
            msf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", msf);

            //获取Session会话实例（javamail Session与HttpSession的区别是Javamail的Session只是配置信息的集合）
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //用户名密码验证（取得的授权吗）
                    return new PasswordAuthentication(addresser, addreCode);
                }
            });

            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人地址
            message.setFrom(new InternetAddress(addresser));
            // 设置收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(addressee));
            // 设置邮件主题
            message.setSubject(emailSubject);
            // 封装需要发送电子邮件的信息
            message.setText(contentOfEmail);
            // 发送消息
            Transport.send(message);

            zhi = true;
        } catch (Exception e) {
            zhi = false;
        }

        return zhi;
    }

}


