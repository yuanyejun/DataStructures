package cn.structures.linkedlist;

/**
 * @Author 原野
 * @DATE 2023/9/15 15:46
 * @Description: 双向链表的实现
 * @Version 1.0
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        System.out.println("双向链表测试");
        HeroNodes hero1 = new HeroNodes(1, "宋江", "及时雨");
        HeroNodes hero2 = new HeroNodes(2, "吴用", "及时雨");
        HeroNodes hero3 = new HeroNodes(3, "林冲", "豹子头");
        HeroNodes hero4 = new HeroNodes(4, "卢俊义", "玉麒麟");
        //创建双向链表
        DoubleLinkedListDemo doubleLinkedListDemo = new DoubleLinkedListDemo();
        doubleLinkedListDemo.add(hero1);
        doubleLinkedListDemo.add(hero2);
        doubleLinkedListDemo.add(hero3);
        doubleLinkedListDemo.add(hero4);

        doubleLinkedListDemo.list();

        //修改
//        HeroNodes o = new HeroNodes(3, "林冲冲", "及时雨");
//        doubleLinkedListDemo.update(o);
//        doubleLinkedListDemo.list();

        //删除
//        doubleLinkedListDemo.del(3);
//        doubleLinkedListDemo.list();

//        doubleLinkedListDemo.



    }

    //先初始化一个头节点，头节点不要动 不存放具体的数据
    private HeroNodes head = new HeroNodes(0,"","");

    //返回头节点
    public HeroNodes getHead(){
        return head;
    }

    //显示链表(遍历)
    public void list(){

        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 因为head节点不能动,因此我们需要一个辅助遍历
        HeroNodes temp = head.next;
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

    //添加节点到单向列表
    // 当不考虑编号的顺序时
    // 1.找到当前链表的最后节点
    // 2. 将最后这个节点的next指向新的节点
    public void add(HeroNodes heroNodes){

        // 因为head节点不能动,因此我们需要一个辅助遍历temp
        HeroNodes temp = head;
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
        //形成一个双向列表
        temp.next = heroNodes;
        heroNodes.pre = temp;
    }

    //完成修改节点的信息，根据编号来修改，即no编号不能改
    //heroNode的no来修改即可
    //修改一个节点的内容 可以看到双向链表的节点内容和前面的单链表基本相同
    //只是节点的类型改成了HeroNodes
    public void update(HeroNodes heroNodes){

        //判断是否空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNodes temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true){
            if (temp == null){
                break; //已经遍历完链表
            }
            if (temp.no == heroNodes.no){
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = heroNodes.name;
            temp.nickname = heroNodes.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点,不能修改\n",heroNodes.no);
        }
    }

    //删除节点
    //思路
    // 对于双向链表 我们可以直接找到要删除的这个节点
    // 找到后 自我删除即可
    public  void del(int no){

        //判断当前列表是否为空
        if (head.next == null){
            System.out.println("链表为空 无法删除");
            return;
        }

        HeroNodes temp = head.next; //辅助指针 变量
        boolean flag = false; //标志是否找到待删除节点
        while (true){
            if (temp == null){
                System.out.println("链表为空...");
                break;
            }
            if (temp.no == no){
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历

        }

        // 判断flag
        if (flag){ //找到
//            temp.next = temp.next.next; //删除 单向链表删除思路
            temp.pre.next = temp.next;
            // ??? 如果是最后一个节点 就不需要执行下面这句话 否则出现空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("要删除的节点不存在");
        }

    }
}

//创建一个双向链表的类
class HeroNodes{

    public  int no;
    public String name;
    public String nickname;
    public  HeroNodes next; //指向下一个节点 默认为空
    public  HeroNodes pre; //指向上一个节点 默认为空
    //构造器
    public HeroNodes(int no, String name, String nickname) {
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