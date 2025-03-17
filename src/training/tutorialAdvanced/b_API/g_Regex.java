package training.tutorialAdvanced.b_API;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g_Regex {
    public static void main(String[] args) {
        // 1. Pattern 类,将正则表达式编译成一个正则表达式的专用的类
        String regex = "\\d{3}-\\d{2}-\\d{4}"; // 匹配社会安全号码， 123-45-6789
            // 1.1 matchers方法, 用于对输入字符串进行匹配,主要用于简单的匹配而不是提取
        String text = "123-45-6789";
        boolean isMatch = Pattern.matches(regex,text);
        System.out.println("Is match: " + isMatch); // 输出true
            // 或者：
        System.out.println("Is match: " + text.matches(regex));
            // 1.2 compile方法, 用于将正则表达式编译成一个模式类
        Pattern pattern = Pattern.compile(regex);

        // 2. Matcher 类, 文本匹配器的对象， 用于对输入字符串进行匹配甚至提取
        String userInput = "User social number: 123-45-6789";
            //2.1 通过pattern类的方法获取到matcher对象
        Matcher matcher = pattern.matcher(userInput);
            //2.2 通过matcher类的方法进行匹配
        while(matcher.find()){
            System.out.println("Found: " + matcher.group()); // 输出123-45-6789
        }

        // 常见使用场景
        // 1.邮箱验证
        String userEmail = "123123.com";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        System.out.println("User Email valid? " + Pattern.matches(userEmail,emailRegex));
        // 2. 提取指定的文本信息
        String textInfo = "Java is a programming language. Java is also a platform. It is used for web development.";
        Pattern p = Pattern.compile("Java"); // 匹配Java字符
        Matcher m = p.matcher(textInfo);
        while(m.find()){
            System.out.println("Found: " + m.group()); // 输出Java
        }
        // 3. 替换文本
        String textToReplace = "Java is a programming language. Java is also a platform.";
        String replacement = textToReplace.replace("Java", "Programming"); // 传递要替换的文本正则表达式
        System.out.println("Replaced text: " + replacement); // 输出Programming is a programming language. Programming is also a platform.
        // 4. 分割字符串
        String textToSplit = "Java,Python,C++,JavaScript";
        String[] languages = textToSplit.split(","); // 传递分隔符的正则表达式
        for (String language : languages) {
            System.out.println("Language: " + language); // 输出Java, Python, C++, JavaScript
        }

        // 5.贪婪匹配
        String demoText = "<div>Content</div><div>More Content</div>";
        String greedyRegex = "<div>.*</div>"; // 贪婪匹配
        Pattern greedyP = Pattern.compile(greedyRegex);
        Matcher greedyM = greedyP.matcher(demoText);
        while(greedyM.find()){
            System.out.println("Greedy match: " + greedyM.group()); // 一次性输出<div>Content</div><div>More Content</div>
        }
        // 6.非贪婪匹配
        String nonGreedyRegex = "<div>.*?</div>"; // 非贪婪匹配,增加了?，表示非贪婪匹配
        Pattern nonGreedyP = Pattern.compile(nonGreedyRegex);
        Matcher nonGreedyM = nonGreedyP.matcher(demoText);
        while(nonGreedyM.find()){
            System.out.println("Non-greedy match: " + nonGreedyM.group()); // 分两次输出<div>Content</div>和<div>More Content</div>
        }

    }
}
