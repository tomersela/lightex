/* LightexParserTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. LightexParserTokenManager.java */
package com.tomersela.lightex.parser;
import com.tomersela.lightex.parser.exceptions.InvalidSymbol;
import com.tomersela.lightex.parser.exceptions.EmptyCode;
import com.tomersela.lightex.parser.exceptions.LightexParseException;
import com.tomersela.lightex.parser.exceptions.UnexpectedEndOfCode;
import com.tomersela.lightex.ast.*;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.LinkedList;

/** Token Manager. */
@SuppressWarnings ("unused")
public class LightexParserTokenManager implements LightexParserConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 9:
         jjmatchedKind = 2;
         return jjMoveNfa_0(0, 0);
      case 10:
         jjmatchedKind = 3;
         return jjMoveNfa_0(0, 0);
      case 13:
         jjmatchedKind = 4;
         return jjMoveNfa_0(0, 0);
      case 32:
         jjmatchedKind = 1;
         return jjMoveNfa_0(0, 0);
      case 33:
         jjmatchedKind = 20;
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 37:
         jjmatchedKind = 12;
         return jjMoveNfa_0(0, 0);
      case 40:
         jjmatchedKind = 7;
         return jjMoveNfa_0(0, 0);
      case 41:
         jjmatchedKind = 8;
         return jjMoveNfa_0(0, 0);
      case 42:
         jjmatchedKind = 11;
         return jjMoveNfa_0(0, 0);
      case 43:
         jjmatchedKind = 9;
         return jjMoveNfa_0(0, 0);
      case 44:
         jjmatchedKind = 28;
         return jjMoveNfa_0(0, 0);
      case 45:
         jjmatchedKind = 10;
         return jjMoveNfa_0(0, 0);
      case 47:
         jjmatchedKind = 14;
         return jjMoveNfa_0(0, 0);
      case 60:
         jjmatchedKind = 24;
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 61:
         jjmatchedKind = 21;
         return jjMoveNfa_0(0, 0);
      case 62:
         jjmatchedKind = 22;
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 94:
         jjmatchedKind = 13;
         return jjMoveNfa_0(0, 0);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 123:
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(0, 0);
   }
   switch(curChar)
   {
      case 61:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 25;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x4000000L) != 0L)
         {
            jjmatchedKind = 26;
            jjmatchedPos = 1;
         }
         break;
      case 78:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 82:
         if ((active0 & 0x80000L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 1;
         }
         break;
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 114:
         if ((active0 & 0x80000L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 1;
         }
         break;
      case 123:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 1;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(0, 1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(0, 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(0, 1);
   }
   switch(curChar)
   {
      case 68:
         if ((active0 & 0x40000L) != 0L)
         {
            jjmatchedKind = 18;
            jjmatchedPos = 2;
         }
         break;
      case 100:
         if ((active0 & 0x40000L) != 0L)
         {
            jjmatchedKind = 18;
            jjmatchedPos = 2;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(0, 2);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int strKind = jjmatchedKind;
   int strPos = jjmatchedPos;
   int seenUpto;
   input_stream.backup(seenUpto = curPos + 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { throw new Error("Internal Error"); }
   curPos = 0;
   int startsAt = 0;
   jjnewStateCnt = 47;
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
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     { jjCheckNAddStates(0, 4); }
                  }
                  else if (curChar == 47)
                     { jjAddStates(5, 6); }
                  else if (curChar == 39)
                     { jjCheckNAddStates(7, 9); }
                  else if (curChar == 34)
                     { jjCheckNAddStates(10, 12); }
                  else if (curChar == 46)
                     { jjCheckNAdd(1); }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  { jjCheckNAdd(1); }
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 12:
                  if (curChar == 34)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 13:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 15:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 16:
                  if (curChar == 34 && kind > 29)
                     kind = 29;
                  break;
               case 17:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(13, 16); }
                  break;
               case 18:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 19:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 20:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(18); }
                  break;
               case 21:
                  if (curChar == 39)
                     { jjCheckNAddStates(7, 9); }
                  break;
               case 22:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     { jjCheckNAddStates(7, 9); }
                  break;
               case 24:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(7, 9); }
                  break;
               case 25:
                  if (curChar == 39 && kind > 30)
                     kind = 30;
                  break;
               case 26:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(17, 20); }
                  break;
               case 27:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(7, 9); }
                  break;
               case 28:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 29:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAdd(27); }
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  { jjCheckNAddStates(0, 4); }
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  { jjCheckNAdd(31); }
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(32, 33); }
                  break;
               case 33:
                  if (curChar == 46)
                     { jjCheckNAdd(34); }
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  { jjCheckNAdd(34); }
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(35, 36); }
                  break;
               case 36:
                  if (curChar == 46 && kind > 15)
                     kind = 15;
                  break;
               case 37:
                  if (curChar == 47)
                     { jjAddStates(5, 6); }
                  break;
               case 38:
                  if (curChar == 42)
                     { jjCheckNAddTwoStates(39, 41); }
                  break;
               case 39:
                  { jjCheckNAddTwoStates(39, 41); }
                  break;
               case 40:
                  if (curChar == 47 && kind > 5)
                     kind = 5;
                  break;
               case 41:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 40;
                  break;
               case 42:
                  if (curChar == 47)
                     { jjCheckNAddStates(21, 23); }
                  break;
               case 43:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     { jjCheckNAddStates(21, 23); }
                  break;
               case 44:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 45:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 46:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 45;
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
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 27)
                        kind = 27;
                     { jjCheckNAdd(11); }
                  }
                  if ((0x4000000040L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 8;
                  else if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 2:
                  if ((0x2000000020L & l) != 0L && kind > 17)
                     kind = 17;
                  break;
               case 3:
                  if ((0x20000000200000L & l) != 0L)
                     { jjCheckNAdd(2); }
                  break;
               case 4:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if ((0x8000000080000L & l) != 0L)
                     { jjCheckNAdd(2); }
                  break;
               case 7:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if ((0x4000000040L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
               case 11:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  { jjCheckNAdd(11); }
                  break;
               case 13:
                  { jjCheckNAddStates(10, 12); }
                  break;
               case 14:
                  if (curChar == 92)
                     { jjAddStates(24, 26); }
                  break;
               case 15:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAddStates(10, 12); }
                  break;
               case 22:
                  { jjCheckNAddStates(7, 9); }
                  break;
               case 23:
                  if (curChar == 92)
                     { jjAddStates(27, 29); }
                  break;
               case 24:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAddStates(7, 9); }
                  break;
               case 39:
                  { jjAddStates(30, 31); }
                  break;
               case 43:
                  { jjAddStates(21, 23); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 13:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(10, 12); }
                  break;
               case 22:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(7, 9); }
                  break;
               case 39:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(30, 31); }
                  break;
               case 43:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(21, 23); }
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
      if ((i = jjnewStateCnt) == (startsAt = 47 - (jjnewStateCnt = startsAt)))
         break;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { break; }
   }
   if (jjmatchedPos > strPos)
      return curPos;

   int toRet = Math.max(curPos, seenUpto);

   if (curPos < toRet)
      for (i = toRet - Math.min(curPos, seenUpto); i-- > 0; )
         try { curChar = input_stream.readChar(); }
         catch(java.io.IOException e) { throw new Error("Internal Error : Please send a bug report."); }

   if (jjmatchedPos < strPos)
   {
      jjmatchedKind = strKind;
      jjmatchedPos = strPos;
   }
   else if (jjmatchedPos == strPos && jjmatchedKind > strKind)
      jjmatchedKind = strKind;

   return toRet;
}
private final int jjStopStringLiteralDfa_1(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_1(int pos, long active0){
   return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
}
private int jjMoveStringLiteralDfa0_1(){
   switch(curChar)
   {
      case 125:
         return jjMoveStringLiteralDfa1_1(0x100000000L);
      default :
         return jjMoveNfa_1(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_1(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 125:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         break;
      default :
         break;
   }
   return jjStartNfa_1(0, active0);
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 1;
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
               case 0:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     kind = 33;
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
               case 0:
                  if ((0xdfffffffffffffffL & l) != 0L)
                     kind = 33;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((jjbitVec0[i2] & l2) != 0L && kind > 33)
                     kind = 33;
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
      if ((i = jjnewStateCnt) == (startsAt = 1 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\50", "\51", "\53", "\55", "\52", 
"\45", "\136", "\57", null, null, null, null, null, "\41", "\75", "\76", "\76\75", 
"\74", "\74\75", "\41\75", null, "\54", null, null, null, null, null, };
protected Token jjFillToken()
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
static final int[] jjnextStates = {
   31, 32, 33, 35, 36, 38, 42, 22, 23, 25, 13, 14, 16, 13, 14, 18, 
   16, 22, 23, 27, 25, 43, 44, 46, 15, 17, 19, 24, 26, 28, 39, 41, 
};

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
           }
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
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
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public LightexParserTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public LightexParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 47; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "WithinPlaceHolder",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, 1, 0, -1, 
};
static final long[] jjtoToken = {
   0x17ffeff81L, 
};
static final long[] jjtoSkip = {
   0x7eL, 
};
static final long[] jjtoSpecial = {
   0x40L, 
};
static final long[] jjtoMore = {
   0x280000000L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[47];
    private final int[] jjstateSet = new int[2 * 47];
    private final StringBuilder jjimage = new StringBuilder();
    private StringBuilder image = jjimage;
    private int jjimageLen;
    private int lengthOfMatch;
    protected int curChar;
}
