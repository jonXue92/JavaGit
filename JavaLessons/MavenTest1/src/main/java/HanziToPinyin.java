import java.util.Scanner;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

public class HanziToPinyin {

	static HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
	static {
		outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		outputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
		outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
	}
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(PinyinHelper.toHanYuPinyinString(str, outputFormat, " ", true));
		in.close();
	}
}
