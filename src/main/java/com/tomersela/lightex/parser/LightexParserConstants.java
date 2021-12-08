/* Generated By:JavaCC: Do not edit this line. LightexParserConstants.java */
package com.tomersela.lightex.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface LightexParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 6;
  /** RegularExpression Id. */
  int LPAREN = 7;
  /** RegularExpression Id. */
  int RPAREN = 8;
  /** RegularExpression Id. */
  int PLUS = 9;
  /** RegularExpression Id. */
  int MINUS = 10;
  /** RegularExpression Id. */
  int TIMES = 11;
  /** RegularExpression Id. */
  int MOD = 12;
  /** RegularExpression Id. */
  int POW = 13;
  /** RegularExpression Id. */
  int DIV = 14;
  /** RegularExpression Id. */
  int NUMBER = 15;
  /** RegularExpression Id. */
  int DIGITS = 16;
  /** RegularExpression Id. */
  int BOOLEAN = 17;
  /** RegularExpression Id. */
  int AND = 18;
  /** RegularExpression Id. */
  int OR = 19;
  /** RegularExpression Id. */
  int EXCLAMATION = 20;
  /** RegularExpression Id. */
  int EQUAL = 21;
  /** RegularExpression Id. */
  int GREATER = 22;
  /** RegularExpression Id. */
  int GREATER_EQUAL = 23;
  /** RegularExpression Id. */
  int LESS = 24;
  /** RegularExpression Id. */
  int LESS_EQUAL = 25;
  /** RegularExpression Id. */
  int NOT_EQUAL = 26;
  /** RegularExpression Id. */
  int ID = 27;
  /** RegularExpression Id. */
  int COMMA = 28;
  /** RegularExpression Id. */
  int STRING = 29;
  /** RegularExpression Id. */
  int STRING_QUOTE = 30;
  /** RegularExpression Id. */
  int RPLACE_HOLDER = 32;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int WithinPlaceHolder = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<token of kind 5>",
    "<SINGLE_LINE_COMMENT>",
    "\"(\"",
    "\")\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"%\"",
    "\"^\"",
    "\"/\"",
    "<NUMBER>",
    "<DIGITS>",
    "<BOOLEAN>",
    "\"and\"",
    "\"or\"",
    "\"!\"",
    "\"=\"",
    "\">\"",
    "\">=\"",
    "\"<\"",
    "\"<=\"",
    "\"!=\"",
    "<ID>",
    "\",\"",
    "<STRING>",
    "<STRING_QUOTE>",
    "\"{{\"",
    "\"}}\"",
    "<token of kind 33>",
  };

}