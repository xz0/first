package generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来从数据库表结构生成Mybatis相关的Domain/Dao/Mapper XML等相关文件.
 * 数据库连接、生成文件所在目录等配置信息，请在generator.xml文件中进行配置。
 */
public class MyBatisGeneratorMain {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = false;
        File configurationFile = new File(MyBatisGeneratorMain.class.getResource("/generator/config.xml").getPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        try {
            Configuration config = cp.parseConfiguration(configurationFile);
            DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
    //        myBatisGenerator.generate(new NullProgressCallback());
            myBatisGenerator.generate(null);
            System.out.println("成功");
        } catch (Exception e) {
            System.out.println("失败");
            e.printStackTrace();
        }
    }

}
