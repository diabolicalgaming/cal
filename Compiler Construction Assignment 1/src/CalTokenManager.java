/* Generated By:JavaCC: Do not edit this line. CalTokenManager.java */
import java.io.*;
import java.util.*;

/** Token Manager. */
public class CalTokenManager implements CalConstants
{
        static int commentNesting = 0;

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x40L) != 0L)
            return 0;
         if ((active0 & 0x7fff800L) != 0L)
         {
            jjmatchedKind = 47;
            return 8;
         }
         if ((active0 & 0x400000000L) != 0L)
            return 10;
         return -1;
      case 1:
         if ((active0 & 0x5fbf800L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 1;
            return 8;
         }
         if ((active0 & 0x2040000L) != 0L)
            return 8;
         return -1;
      case 2:
         if ((active0 & 0x4fbf800L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 2;
            return 8;
         }
         if ((active0 & 0x1000000L) != 0L)
            return 8;
         return -1;
      case 3:
         if ((active0 & 0x41b0000L) != 0L)
            return 8;
         if ((active0 & 0xe0f800L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 3;
            return 8;
         }
         return -1;
      case 4:
         if ((active0 & 0xe00000L) != 0L)
            return 8;
         if ((active0 & 0xf800L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 4;
            return 8;
         }
         return -1;
      case 5:
         if ((active0 & 0x2000L) != 0L)
            return 8;
         if ((active0 & 0xd800L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 5;
            return 8;
         }
         return -1;
      case 6:
         if ((active0 & 0xc000L) != 0L)
            return 8;
         if ((active0 & 0x1800L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 6;
            return 8;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 38:
         return jjStopAtPos(0, 37);
      case 40:
         return jjStopAtPos(0, 31);
      case 41:
         return jjStopAtPos(0, 32);
      case 43:
         return jjStopAtPos(0, 33);
      case 44:
         return jjStopAtPos(0, 27);
      case 45:
         return jjStartNfaWithStates_0(0, 34, 10);
      case 47:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 58:
         jjmatchedKind = 29;
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 59:
         return jjStopAtPos(0, 28);
      case 60:
         jjmatchedKind = 40;
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 61:
         return jjStopAtPos(0, 38);
      case 62:
         jjmatchedKind = 42;
         return jjMoveStringLiteralDfa1_0(0x80000000000L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_0(0x808000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_0(0x1080000L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x2044000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa1_0(0x10800L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 124:
         return jjStopAtPos(0, 36);
      case 126:
         return jjStopAtPos(0, 35);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 61:
         if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 41);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStopAtPos(1, 43);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x220800L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x802000L);
      case 70:
      case 102:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(1, 18, 8);
         break;
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L);
      case 75:
      case 107:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x1004000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x19000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 83:
      case 115:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(1, 25, 8);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 68:
      case 100:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 8);
         break;
      case 71:
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x4430000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x6000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 68:
      case 100:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 16, 8);
         break;
      case 69:
      case 101:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 19, 8);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 8);
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x800800L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x408000L);
      case 78:
      case 110:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(3, 17, 8);
         break;
      case 80:
      case 112:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(3, 26, 8);
         break;
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x201000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x800L);
      case 69:
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(4, 21, 8);
         else if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(4, 22, 8);
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 78:
      case 110:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 8);
         break;
      case 82:
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x9000L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000L);
      case 78:
      case 110:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(5, 13, 8);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 76:
      case 108:
         return jjMoveStringLiteralDfa7_0(active0, 0x800L);
      case 78:
      case 110:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(6, 15, 8);
         return jjMoveStringLiteralDfa7_0(active0, 0x1000L);
      case 82:
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(6, 14, 8);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(7, 11, 8);
         break;
      case 84:
      case 116:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(7, 12, 8);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 10;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 10:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     jjCheckNAdd(6);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 46)
                        kind = 46;
                  }
                  break;
               case 3:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 46)
                        kind = 46;
                     jjCheckNAdd(6);
                  }
                  else if (curChar == 45)
                     jjAddStates(0, 1);
                  else if (curChar == 48)
                  {
                     if (kind > 46)
                        kind = 46;
                  }
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 47)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 1:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar == 10)
                     kind = 10;
                  break;
               case 4:
                  if (curChar == 48 && kind > 46)
                     kind = 46;
                  break;
               case 5:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjCheckNAdd(6);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjCheckNAdd(6);
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 9:
                  if (curChar == 45)
                     jjAddStates(0, 1);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(8);
                  break;
               case 1:
                  jjAddStates(2, 3);
                  break;
               case 8:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(8);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(2, 3);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 10 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x100L);
      case 47:
         return jjMoveStringLiteralDfa1_1(0x80L);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
         break;
      case 47:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   4, 5, 1, 2, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
"\54", "\73", "\72", "\72\75", "\50", "\51", "\53", "\55", "\176", "\174", "\46", 
"\75", "\41\75", "\74", "\74\75", "\76", "\76\75", null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x1cffffffff801L, 
};
static final long[] jjtoSkip = {
   0x7feL, 
};
static protected JavaCharStream input_stream;
static private final int[] jjrounds = new int[10];
static private final int[] jjstateSet = new int[20];
private static final StringBuilder jjimage = new StringBuilder();
private static StringBuilder image = jjimage;
private static int jjimageLen;
private static int lengthOfMatch;
static protected char curChar;
/** Constructor. */
public CalTokenManager(JavaCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public CalTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 10; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       if (jjmatchedPos == 0 && jjmatchedKind > 48)
       {
          jjmatchedKind = 48;
       }
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 9)
       {
          jjmatchedKind = 9;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
           SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 6 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
               commentNesting++;
         break;
      case 7 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
               commentNesting++;
         break;
      case 8 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
               commentNesting--;
                        if (commentNesting == 0)
                                SwitchTo(DEFAULT);
         break;
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
