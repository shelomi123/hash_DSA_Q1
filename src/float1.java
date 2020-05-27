public class float1
{
    int HashFloat( float x )
   {
      return Float.floatToIntBits(x);
   }

   public void main(String[] args)
   {

       float f = (float) 4.0;

       int x;

       System.out.println("f = " + f);

       x = (int) f;
       System.out.println("(int) f = " + x);

       x = HashFloat( f ) ;
       System.out.println("Float.floatToIntBits(f) = " + x);
   }
}