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
//        String inputString = "/home//foo/";           // Expected: '/home/foo'

//        A : "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."
//        Expected:  "/ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/wrm/grm/ach/jsy/dic/ggz/smq/yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/llb/tud/olc/zns/fiv/eeu/fex/kke/eng/bow/uvz/jmz/hwb/ids/dwj/aqu/erf"
        String inputString = "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/..";
        System.out.println(new SimplifyDirectoryPath().simplifyPath(inputString));
    }

    public String simplifyPath(String A) {
        MyStack<Character> stack = new MyStack<>();
        String result = "";
        char c;
        boolean isPath = false;

        for(int i = 0; i < A.length(); i++) {
//            stack.push(A.charAt(i));
//        }
//
//        while (!stack.isEmpty()) {
            c = A.charAt(i);
            if (c == '/') {
                if (isPath && (!stack.isEmpty() && stack.peek() != '/') || stack.isEmpty()) {
                    result = c + result;
                }
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                isPath = true;
                result = c + result;
            } else {
                break;
            }
        }

        return result.isEmpty() ? "/" : result;
    }
}
