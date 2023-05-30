grammar Mochalov;

program: mainClass classDeclaration*;
// Главный класс
mainClass: 'class' identifier '{' mainMethod '}';
// Запускающий метод
mainMethod: 'public' 'static' 'void' 'main' '(' 'String' ('[' ']'|'...') identifier ')' '{'statement+ '}';
// Класс
classDeclaration: 'class' identifier '{' fieldDeclaration* methodDeclaration* '}';
// Параметер
parameter: type identifier;
// Переменная внутри функции
fieldDeclaration: type identifier  SEMICOLON;
// Метод (функция)
localDeclaration: type identifier SEMICOLON;
// Набор параметров (1 или несколько)
methodDeclaration: 'public'? (type|'void') identifier '(' parameterList? ')' '{' methodBody '}';
// Тело функции в { }
parameterList: parameter(',' parameter)*;
// Тип переменных (и для возврата функций + void)
methodBody: localDeclaration* statement* (returnStatement)?;

type: 'int' '['']'| 'boolean'| 'int' | 'char' | 'String' | 'double' | identifier;

// Идентификатор
identifier: Identifier;

// nested - вложенный statement
statement
:
	  nestedStatement
	| ifElseStatement
	| whileStatement
	| printStatement
	| variableAssignmentStatement
	| arrayAssignmentStatement
	| continueStatement
	| breakStatement
	| returnStatement
	| methodCallStatement
;

// Как пишутся statement (синтаксис)
breakStatement: 'break' SEMICOLON;
continueStatement: 'continue' SEMICOLON;
arrayAssignmentStatement: identifier LEFT_SQUARE_BRACKET expression RIGHT_SQUARE_BRACKET EQUAL expression SEMICOLON;
variableAssignmentStatement: identifier EQUAL expression SEMICOLON;
printStatement: 'System.out.println' LEFT_PARENTHESES(expression) RIGHT_PARENTHESES SEMICOLON;
whileStatement: 'while' LEFT_PARENTHESES expression RIGHT_PARENTHESES statement;
ifElseStatement: 'if' LEFT_PARENTHESES expression RIGHT_PARENTHESES statement ('else' statement)?;
nestedStatement: '{' statement* '}';
returnStatement: 'return' expression SEMICOLON ;
methodCallStatement: expression SEMICOLON;

expression
:
      NOT expression # notExpression
      // Доступ к номеру элементу массива
	| expression LEFT_SQUARE_BRACKET expression RIGHT_SQUARE_BRACKET # arrayAccessExpression
	| expression '.' identifier #fieldAccessExpression
	// Вызов метод
	| expression ('.' identifier methodCallParams)+ # methodCallExpression
	// Вызов класса
	| 'new' identifier '(' ')' # objectInstantiationExpression
	// Объявление массива
    | 'new' type LEFT_SQUARE_BRACKET expression RIGHT_SQUARE_BRACKET # arrayInstantiationExpression
    // Умножение
	| expression TIMES expression # mulExpression
	// Деление
	| expression DIVIDE expression # divExpression
	// Сложение
	| expression PLUS expression # addExpression
	// Вычетание
	| expression MINUS expression # subExpression
	// Меньше чем (или меньне, либо равно)
	| expression LESS_THAN(EQUAL)? expression # lessThanExpression
	// Больше чем (или больше, либо равно)
	| expression GREATER(EQUAL)? expression # greaterthanExpression
	// Равно или не равно
	| expression (EQUAL|NOT) EQUAL expression # equalityExpression
	// и (условный)
	| expression AND expression # andExpression
	// или (условный)
	| expression OR expression # orExpression
	|'this' # thisExpression
	| '(' expression ')' # ParenthesesExpression
	// Строка
	| STRING # stringExpression
	// Символ
	| CHAR # characterExpression
	// Integer
	| ('+'|'-')? IntegerLiteral #integerLitExpression
	// Идентификатор
	| ('+'|'-')? identifier #identifierExpression
	// Bolean (true or false)
	| BooleanLiteral # boolLitExpression
;

methodCallParams: '('(expression(',' expression)*)? ')' ;

DIVIDE:'/';
OR:'||';
GREATER:'>';
AND:'&&';
LESS_THAN:'<';
PLUS:'+';
MINUS:'-';
TIMES:'*';
NOT:'!';
LEFT_SQUARE_BRACKET:'[';
RIGHT_SQUARE_BRACKET:']';
LEFT_PARENTHESES:'(';
RIGHT_PARENTHESES:')';
RETURN:'return';
EQUAL:'=';
BooleanLiteral: 'true'| 'false';
SEMICOLON:';';

Identifier:JavaLetter JavaLetterOrDigit*;

WS: [ \r\t\n]+ -> skip ;
LINE_COMMENT: '//' .*? '\n' -> skip ;
STRING:	'"'(ESC_SEQ| ~( '\\' | '"' ))* '"' ;
CHAR: '\''(ESC_SEQ| ~( '\'' | '\\' )) '\'' ;
IntegerLiteral: DecimalIntegerLiteral ;

fragment JavaLetter : [a-zA-Z$_];
fragment JavaLetterOrDigit:[a-zA-Z0-9$_];
fragment DecimalIntegerLiteral: DecimalNumeral;
fragment DecimalNumeral: '0' | NonZeroDigit (Digits?);
fragment Digits: Digit (Digit)? ;
fragment Digit:'0'| NonZeroDigit;
fragment NonZeroDigit: [1-9];
fragment ESC_SEQ: '\\'('b'| 't'| 'n'| 'f'| 'r'| '"'| '\''| '\\');