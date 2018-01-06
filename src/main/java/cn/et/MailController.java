package cn.et;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	@Autowired
	private JavaMailSender jms;
	
	@GetMapping("/mail")
	public String send(String email_to,String email_content,String email_subject) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom("m17666292862@163.com");
		sm.setTo(email_to);
		sm.setText(email_subject);
		sm.setSubject(email_content);
		jms.send(sm);
		return "1";
	}
	
//	@Value("${server.port}")
//    String port;
    @RequestMapping("/a")
    public String a() {
        return "2";
    }
    
    @GetMapping("/user/{userid}")
    public Map<String, String> getuser(@PathVariable String userid) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", userid);
        map.put("name","zs"+userid);
        return map;
    }
    
    @PostMapping("/sendMail")
	public String sendMail(@RequestBody Map<String,Object> map) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom("m17666292862@163.com");
		sm.setTo(map.get("email_to").toString());
		sm.setText(map.get("email_content").toString());
		sm.setSubject(map.get("email_subject").toString());
		jms.send(sm);
		return "1";
	}
}
