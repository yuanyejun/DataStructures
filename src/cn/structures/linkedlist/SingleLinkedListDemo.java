package cn.structures.linkedlist;

import java.util.Stack;

/**
 * @Author 原野
 * @DATE 2023/9/14 10:52
 * @Description: 单链表的创建和遍历
 * @Version 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {


        //test
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "吴用", "及时雨");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode hero4 = new HeroNode(4, "卢俊义", "玉麒麟");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

//        singleLinkedList.list();

        reversePrint(singleLinkedList.getHead()); //没有改变链表的本身结构


        //反转单链表test
//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();


        //合并两个有序的单链表 合并之后的链表依然有序


//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
////        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero2);
//
//        System.out.println("----");
//
//        reversetList(singleLinkedList.getHead());



//        System.out.println("--------------------------");
//        //测试修改节点的代码
//        HeroNode newHero = new HeroNode(2, "吴用222", "及时雨");
//        singleLinkedList.update(newHero);
//        System.out.println("--------------------------");
//        //删除节点
////        singleLinkedList.del(2);
////        singleLinkedList.del(1);
////        singleLinkedList.del(3);
////        singleLinkedList.del(4);
//        System.out.println("--------------------------");
//        //遍历
//        singleLinkedList.list();
//        System.out.println("--------------------------");
//        //测试是否得到倒数第k个元素
//        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println("lastIndexNode = " + lastIndexNode);
//
//
//        //统计节点的个数
//        System.out.println("有效的节点个数:" + getLength(singleLinkedList.getHead()));
    }

    //将单链表进行反转
    public static void reversetList(HeroNode head){

        //如果当前链表为空1 或者只有一个节点 无需反转 直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表 并从头到尾遍历原来的链表 每遍历一个节点 就将其取出 并放在
        //新的链表reverseHead的最前端

        while (cur != null){
            next = cur.next; //先暂时保存当前节点的下一个节点 后面要使用
            cur.next = reverseHead.next; // 将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur链接到新的链表上
            cur = next; //让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;


    }

    //使用栈 逆序打印
    public static void reversePrint(HeroNode head){

        if (head.next == null){
            return; //空链表
        }
        //创建一个栈 将节点压入栈中
        Stack<HeroNode> stack = new Stack<>();

        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while (cur != null){
            stack.push(cur);
            cur = cur.next; //cur后移  这样就这样压入下一个节点
        }
        //将栈中的节点进行打印 pop出栈
        while (stack.size() > 0){
            System.out.println(stack.pop()); //stack的特点是先进后出
        }


    }


    //查找单链表中的倒数第k个结点(新浪面试题)
    //思路
    // 编写一个方法，接收head节点，同时接收一个index
    // index表示是倒数第index个节点
    // 先把链表从头到尾遍历 得到链表的总长度 getLength()
    // 得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    public static HeroNode findLastIndexNode(HeroNode heroNode,int index){
        if (heroNode.next == null){
            return null;//没有找到
        }
        //第一个遍历得到链表的长度(节点个数
        int size = getLength(heroNode);
        //第二次遍历 size-index位置 就是我们倒数的第k个节点
        //先做一个index校验
        if (index <= 0 || index > size || (size - index) == 0){
            return null;
        }
        //定义给辅助变量 for循环定位到倒数的index
        HeroNode cur = heroNode.next;
        for (int i = 0; i < size - index; i++){
            cur = cur.next;
        }
        return cur;
    }


    //方法：获取到单链表的节点的个数，(如果是带头结点的链表，则不统计头结点)
    /**
     *
     * @param head 链表头结点
     * @return 返回有效结点的个数
     */
    public static int getLength(HeroNode head){

        if (head.next == null){
            return 0; //空链表
        }

        int length = 0;
        //定义一个辅助的变量
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }

}

//定义singlelinkedlist,管理英雄
class  SingleLinkedList{

    //先初始化一个头节点，头节点不要动
    private HeroNode head = new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead(){
        return head;
    }


    //添加节点到单向列表
    // 当不考虑编号的顺序时
    // 1.找到当前链表的最后节点
    // 2. 将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){

        // 因为head节点不能动,因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后,将temp后移
            temp = temp.next;
        }
        //当退出循环,temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    //删除节点
    //思路
    //1.head不能动,因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    // 2.说明我们在比较时 是temp.next.no和需要删除的节点no比较
    public  void del(Integer no){
        HeroNode temp = head;
        boolean flag = false; //标志是否找到待删除节点
        while (true){
            if (temp.next == null){
                System.out.println("链表为空...");
                break;
            }
            if (temp.next.no == no){
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历

        }

        // 判断flag
        if (flag){ //找到
            temp.next = temp.next.next; //删除
        }else {
            System.out.println("要删除的节点不存在");
        }

    }


    //显示链表(遍历)
    public void list(){

        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 因为head节点不能动,因此我们需要一个辅助遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    // 如果又这个排名,则添加失败,并给出提示
    public void addByOrder(HeroNode heroNode){

        // 因为head节点不能动,因此我们需要一个辅助指针（变量）来帮助找到添加的位置
        // 因为单链表,因为我们找到找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean falg = false; //标志添加的编号是否存在，默认为false
        while (true){
            if (temp.next == null){ //temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){ //位置找到,就在temp的后面插入
                break;
            }else if (temp.next.no == heroNode.no){ //说明添加的heroNode已经被添加
                falg = true; //说明编号存在
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (falg){ //不能添加,编号已经存在
            System.out.printf("准备插入的%d编号已经存在了\n",heroNode.no);
            return;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }


    //完成修改节点的信息，根据编号来修改，即no编号不能改
    //heroNode的no来修改即可
    public void update(HeroNode heroNode){

        //判断是否空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true){
            if (temp == null){
                break; //已经遍历完链表
            }
            if (temp.no == heroNode.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点,不能修改\n",heroNode.no);
        }

    }

}

//每个heronode对象就是一个节点
class HeroNode{

    public  int no;
    public String name;
    public String nickname;
    public  HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname;
    }
}


