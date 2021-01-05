package before.HuaTu;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMouseAdapter   
{  
    public static void main(String[] args)  
    {  
    	 FileReader fr;
		try {
			fr = new FileReader("d://1.txt");
			BufferedReader br=new BufferedReader(fr);
	         String line="";
	         String[] arrs=null;
             MyFrame f=new  MyFrame("画图");  
	         while ((line=br.readLine())!=null) {
	             arrs=line.split(",");
	             arrs[1]=arrs[1].replaceAll(" ", "").replaceAll("e", "E");
	            BigDecimal bd = new BigDecimal(arrs[1]);  
	             f.addPoint(new Point( (int)(Double.parseDouble(arrs[0])*200+300) ,700- ((int)(Double.parseDouble(bd.toPlainString())*30000+300))));  
	         }
             f.repaint();  
	         br.close();
	         fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        //new MyFrame("drawing");  
       // MyFrame f=(MyFrame)e.getSource();  
       // f.addPoint(new Point(e.getX(),e.getY()));  
        //f.repaint();  
    }
}  
  
class MyFrame extends Frame  
{  
    ArrayList points=null;  
    MyFrame(String s)  
    {  
        super(s);  
        points=new ArrayList();  
        setBounds(300,300,7000,7000);   
        setBackground(new Color(204,204,255));  
        setVisible(true);  
    }  
    public void paint(Graphics g)//重写paint()方法  
    {  
        Iterator i=points.iterator();  
        while(i.hasNext())  
        {  
            Point p=(Point)i.next();  
            g.setColor(Color.BLUE);    //设置颜色  
            g.fillOval(p.x,p.y,5,5); //画实心圆  
            System.out.println(p.x+" "+p.y);

        }  
    }  
    public void addPoint(Point p)  
    {  
        points.add(p);  //将点添加到容器中  
    }  
}  
 