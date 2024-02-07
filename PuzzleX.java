import java.util.Scanner;
class PuzzleX
{
    static char x[][] = new char[4][4],ch;//3 instead of both 4s
    static int row,column;
    static boolean tag = true;
    void display()
    {
        System.out.println("********************************");
        for(int i = 0;i<=3;i++)//2 instead of 3
        {
            System.out.print("\t");
            for(int j = 0;j<=3;j++)//2 instead of 3
                System.out.print("|"+x[i][j]+"| ");
            System.out.println();
        }
        System.out.println("********************************");
    }

    void define()
    {
        int a;
        boolean b[] = new boolean [15];//8 instead of 15
        row = (int)(Math.random() * 4);//3 instead of 4
        column = (int)(Math.random() * 4);//4 instead of 4
        for(int i = 0;i<=3;i++)//2 instead of 3
        {
            for(int j = 0;j<=3;j++)//2 instead of 3
            {
                if((i==row)&&(j==column))
                {
                    x[i][j] = ' ';
                    continue;
                }
                a = (int)((Math.random()* 15) + 1);//8 instead of 15
                while(b[a-1]==true)
                    a = (int)((Math.random()* 15) + 1);//8 instead of 15
                x[i][j] = (char)(a+'0');
                b[a-1] = true;
            }
        }
    }

    void shift()
    {
        if(ch=='s')
        {
            if(row!=0)
            {    
                x[row][column] = x[row-1][column];
                row--;
            }
        }
        else if(ch=='w')
        {
            if(row!=3)//2 instead of 3
            {
                x[row][column] = x[row+1][column];
                row++;
            }
        }
        else if(ch=='d')
        {
            if(column!=0)
            {
                x[row][column] = x[row][column-1];
                column--;
            }
        }
        else if(ch=='a')
        {
            if(column!=3)//2 instead of 3
            {
                x[row][column] = x[row][column+1];
                column++;
            }
        }
        x[row][column] = ' ';
    }

    boolean answer()
    {
        if((x[0][0]=='1')&&(x[0][1]=='2')&&(x[0][2]=='3')&&(x[1][0]=='4')&&(x[1][1]=='5')&&(x[1][2]=='6')&&(x[2][0]=='7')&&(x[2][1]=='8')&&(x[2][2]=='9'))
            return true;
        return false;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        PuzzleX ob = new PuzzleX();
        System.out.println("--------------------------------");
        System.out.println("Press 'w' for UP\nPress 's' for DOWN\nPress 'a' for LEFT\nPress 'd' for RIGHT\nPress 'e' to RESHUFFLE\nPress 'q' to QUIT");
        System.out.println("--------------------------------\n'*' is BLANK\n--------------------------------");
        ob.define();
        while(ob.answer()==false)
        {
            ob.display();
            ch = sc.next().charAt(0);
            if(ch=='q')
                break;
            if(ch=='e')
            {
                ob.define();
                continue;
            }
            ob.shift();
        }
        if(ch!='q')
        {
            ob.display();
            System.out.println("--------------------------------\n------------You WIN!------------\n--------------------------------");
        }
        System.out.println("--------------------------------");
        System.out.println("Press 'e' to play AGAIN\nPress 'q' to EXIT");
        System.out.println("--------------------------------");
        if(sc.next().charAt(0)=='e')
        {
            ob.main(null);
        }
        if(tag==true)
        {    System.out.println("--------------------------------\n-----------Thank You!-----------\n--------------------------------");
            tag = false;
        }
    }
}