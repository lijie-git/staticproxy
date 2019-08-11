public class StaticProxy {
    public static void main(String[] args) {
    Son son=new Son();
    Father father=new Father(son);
    father.Marry();
    }
}

interface person{
    public abstract void Marry();

}

class Son implements person{
    @Override
    public void Marry() {
        System.out.println("我要结婚拉");
    }
}

class Father implements person{
    Son son;
    public Father(Son son){
        this.son=son;
    }
    @Override
    public void Marry() {
        System.out.println("准备家庄！");
    son.Marry();
    }
}