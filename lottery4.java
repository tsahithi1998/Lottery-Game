import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
class lottery extends Frame
{
Label l1,l6;
TextArea ta;
TextField t6;
lottery()
{
setLayout(null);
ta=new TextArea();
t6=new TextField();
l1=new Label("winners are");
l6=new Label("time remaining");
add(l1);
add(ta);
add(l6);
add(t6);
ta.setEditable(false);
t6.setBounds(280,300,100,20);
l6.setBounds(150,300,100,20);
l1.setBounds(150,150,100,20);
ta.setBounds(270,150,200,100);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
System.exit(0);
}
});
}
}
class lottery4
{
public static void main(String args[])
{
lottery l=new lottery();
lottery1 l3=new lottery1(l);
l.setSize(500,500);
l.setVisible(true);
l.setTitle("lottery");
l3.setDaemon(true);
l3.start();
}
}
class lottery1 extends Thread
{
lottery l2;
lottery1(lottery l2)
{
this.l2=l2;
}
public void run()
{
try{
while(true)
{
Long diff;
SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
SimpleDateFormat sd=new SimpleDateFormat("HH:mm:ss");
String str9=sd.format(new Date());
Date d1=format.parse(str9);
String a,b,c,d,e,f,g,h,i1;
//sample="18:44:00";
a="03:00:00";
b="06:00:00";
c="09:00:00";
d="12:00:00";
e="15:00:00";
f="18:00:00";
g="21:00:00";
h="24:00:00";
Date d2=format.parse(a);
Date d3=format.parse(b);
Date d4=format.parse(c);
Date d5=format.parse(d);
Date d6=format.parse(e);
Date d7=format.parse(f);
Date d8=format.parse(g);
Date d9=format.parse(h);
//Date d10=format.parse(sample);
if((d1.after(d2))&&(d1.before(d3)))
{
diff=(d3.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d3))&&(d1.before(d4)))
{
diff=(d4.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d4))&&(d1.before(d5)))
{
diff=(d5.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d5))&&(d1.before(d6)))
{
diff=(d6.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d6))&&(d1.before(d7)))
{
diff=(d7.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d7))&&(d1.before(d8)))
{
diff=(d8.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d8))&&(d1.before(d9)))
{
diff=(d9.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if((d1.after(d9))&&(d1.before(d2)))
{
diff=(d2.getTime()-d1.getTime())/1000;
i1=Long.toString(diff);
l2.t6.setText(i1+"secs");
}
if(d1.equals(d2)||d1.equals(d3)||d1.equals(d4)||d1.equals(d5)||d1.equals(d6)||d1.equals(d7)||d1.equals(d8)||d1.equals(d9))
{
Random rand=new Random();
BufferedReader fin=new BufferedReader(new FileReader("lottery.txt"));
int i=0,first,second,third;
String str,arr[]=new String[20];
while((str=fin.readLine())!=null)
{
arr[i++]=str;
}
first=rand.nextInt(i-1);
while(true)
{
second=rand.nextInt(i-1);
if(second==first)
continue;
else
break;
}
while(true)
{
third=rand.nextInt(i-1);
if((third==second)||(third==first))
continue;
else
break;
}
l2.ta.setText("1."+arr[first]+"\n 2."+arr[second]+"\n 3. "+arr[third]);
}
Thread.sleep(50);
}
}
catch(IOException e1)
{
System.out.println(e1);
}
catch(InterruptedException e1)
{
System.out.println(e1);
}
catch (ParseException e1)
{
e1.printStackTrace();
}
}
}