package creatercaccount.lingdian.com.creatercaccount;

/**
 * Created by lingdian on 2017/12/1.
 */

/**
 * 根据情况替换
 * StringBuffer
 * 目前 不确定使用Builder还是Buffer
 */
public class MyStringBuilder {
    private StringBuilder sb;

    public MyStringBuilder() {
        sb = new StringBuilder();
    }

    public MyStringBuilder(String baseStr) {
        sb = new StringBuilder(baseStr);
    }

    public MyStringBuilder append(String append) {
        sb.append(append);
        return this;
    }

    public MyStringBuilder append(char[] append) {
        sb.append(append);return this;
    }

    public MyStringBuilder append(int append) {
        sb.append(append);return this;
    }

    public MyStringBuilder append(short append) {
        sb.append(append);return this;
    }

    public MyStringBuilder append(long append) {
        sb.append(append);return this;
    }

    public MyStringBuilder append(double append) {
        sb.append(append);return this;
    }

    public MyStringBuilder append(float append) {
        sb.append(append);return this;
    }

    public MyStringBuilder append(boolean append) {
        sb.append(append);return this;
    }

    public int length() {
        return sb.length();
    }

    public String toString() {
        return sb.toString();
    }
}
