package cn.mxy.spider.weixin.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

	public static String readFileToString(String path) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(new File(path));
		BufferedReader br = new BufferedReader(fileReader);
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String html = sb.toString();
		return html;
	}
	public static void saveStringToFile(String html,String path) throws FileNotFoundException, IOException {
		File file = new File(path);
		BufferedWriter bwBufferedWriter = new BufferedWriter(new FileWriter(file));
		bwBufferedWriter.write(html);
		bwBufferedWriter.flush();
		bwBufferedWriter.close();
	}

}
