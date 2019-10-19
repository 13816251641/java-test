package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 依赖freemarker.jar
 * 利用freemarker输出指定文件到指定目录后填充字段
 */
public class FreemarkerTest {
    private static final String TEMPLATE_PATH = "D:/airflowfile";
    private static final String FILE_NAME="190815-AirflowTaskTemplate_v1.md";
    private static final String OUTPUT_PATH = "D:/airflowfile";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 如果为空直接设置为空字符串,否则要指定默认字段不然代码报错
        configuration.setClassicCompatible(true);
        // 解决1,000千分符号问题
        configuration.setNumberFormat("#");
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("name", "hello world");
            // step4 加载模版文件
            Template template = configuration.getTemplate(FILE_NAME);
            // step5 生成数据
            File docFile = new File(OUTPUT_PATH + File.separator + "copy.py");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^copy.py 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
