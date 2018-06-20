package com.interviewbit.stacksandqueues;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * Examples:
 *
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Note that absolute path always begin with ‘/’ ( root directory )
 * Path will not have whitespace characters.
 */

public class SimplifyDirectoryPath extends MyStack {
    public static void main (String args[]) {
//        String inputString = "/home/";                // Expected: '/home'
//        String inputString = "/a/./b/../../c/";       // Expected: '/c'
//        String inputString = "/../";                  // Expected: '/'
        String inputString = "/home//foo/";           // Expected: '/home/foo'

//        A : "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."
//        Expected:  "/ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/wrm/grm/ach/jsy/dic/ggz/smq/yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/llb/tud/olc/zns/fiv/eeu/fex/kke/eng/bow/uvz/jmz/hwb/ids/dwj/aqu/erf"
//        String inputString = "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/..";

//        A : "/cbj/vfb/dyj/../../hjq/./unc/./cmv/./axj/../pzg/svs/oja/./rlc/vyr/cqq/../omk/viy/kyb/../ygr/mbx/nom/yvh/./../././lyg/qjv/./lwm/.././.././xga/krs/../xkl/wtj/nml/dal/hat/alw/jvo/./../xts/nul/yfe/upg/zhy/nzo/dtp/nqt/hqk/./../ref/gms/zhp/./bpp/jis/ccc/bmn/iip/nfv/../vbk/ugr/gpd/uez/./bqt/zqy/../vuf/ltg/mxm/../lvr/vef/../wpp/./rbc/xii/pkf/jsx/././xwo"
//        Expected:  "/cbj/hjq/unc/cmv/pzg/svs/oja/rlc/vyr/omk/viy/ygr/mbx/nom/lyg/xga/xkl/wtj/nml/dal/hat/alw/xts/nul/yfe/upg/zhy/nzo/dtp/nqt/ref/gms/zhp/bpp/jis/ccc/bmn/iip/vbk/ugr/gpd/uez/bqt/vuf/ltg/lvr/wpp/rbc/xii/pkf/jsx/xwo"
//        String inputString = "A : \"/cbj/vfb/dyj/../../hjq/./unc/./cmv/./axj/../pzg/svs/oja/./rlc/vyr/cqq/../omk/viy/kyb/../ygr/mbx/nom/yvh/./../././lyg/qjv/./lwm/.././.././xga/krs/../xkl/wtj/nml/dal/hat/alw/jvo/./../xts/nul/yfe/upg/zhy/nzo/dtp/nqt/hqk/./../ref/gms/zhp/./bpp/jis/ccc/bmn/iip/nfv/../vbk/ugr/gpd/uez/./bqt/zqy/../vuf/ltg/mxm/../lvr/vef/../wpp/./rbc/xii/pkf/jsx/././xwo\"\n";

        System.out.println(new SimplifyDirectoryPath().simplifyPath(inputString));
    }

    public String simplifyPath(String A) {
        MyStack<String> stack = new MyStack();
        StringBuilder result = new StringBuilder();
        String substring = "";
        char c;

        for (int i=0; i< A.length(); i++) {
            c = A.charAt(i);

            if (c == '/') {
                if (substring.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (substring.matches("[a-zA-Z0-9]+")) {
                    stack.push(substring);
                }

                substring = "";
            } else {
                substring += c;
            }

            // Edge case for last substring
            if (i == A.length() -1) {
                if (substring.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (substring.matches("[a-zA-Z0-9]+")) {
                    stack.push(substring);
                }
            }
        }

        // Print from the stack
        // Note: String concatenation causes Time limit exception, using StringBuilder instead
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }

        return result.length() < 1 ? "/" : result.toString();
    }
}
