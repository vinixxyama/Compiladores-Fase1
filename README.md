# Compiladores-Fase1
Primeira Fase de Compiladores 2017/1
1 PROBLEMA

Nesta primeira fase será realizada a análise sintática para a linguagem descrita pela gramá-
tica da Seção 2. Esta gramática está parcialmente representada e será completada conforme
as próximas etapas do trabalho, podendo sofrer alterações em certas regras de produção.

2 GRAMATICA

Essa seção define a gramática a ser implementada. As palavras reservadas e símbolos da
linguagem são exibidos entre aspas simples. Elementos da notação da gramática:
• Uma sequência de símbolos entre { e } pode ser repetida zero ou mais vezes;
• Uma sequência de símbolos entre [ e ] é opcional;
• Regras de produção alternativas são separadas por |.
• Comentários devem ser iniciados por ’#’ e terminam com ’\n’.
• Palavras reservadas não podem ser utilizadas como nomes de identificadores.
• . indica qualquer caracter.
• Esta linguagem é case sensitive.
• Mapeamento de símbolos do compilador:
’P’ ’program’
’E’ ’end’
’R’ ’print’
’B’ ’break’
’I’ ’if’
’L’ ’else’
’W’ ’while’
’N’ ’int’
’F’ ’float’
’S’ ’string’

Program ::= ’P’ Name ’:’ Body ’E’

Body ::= [Declaration] Stmt {Stmt}

Declaration ::= Type Name{’,’ Name} {’;’ Type Name{’,’ Name}} ’;’

Stmt ::= SimpleStmt | CompoundStmt

SimpleStmt ::= ExprStmt | PrintStmt | BreakStmt

ExprStmt ::= Name ’=’ Comparison ’;’

PrintStmt ::= ’R’ Comparison {’,’ Comparison} ’;’

BreakStmt ::= ’B’ ’;’
CompoundStmt ::= IfStmt | WhileStmt
IfStmt ::= ’I’ Comparison ’{’ {Stmt} ’}’ [’L’ ’{’ {Stmt} ’}’]
WhileStmt ::= ’W’ Comparison ’{’ {Stmt} ’}’
Comparison ::= Expr [CompOp Expr]
CompOp ::= ’<’ | ’>’
Expr ::= Term {(’+’ | ’-’) Term}
Term ::= Factor {(’*’ | ’/’) Factor}
Factor ::= Name | Number | String
Type ::= ’N’ | ’F’ | ’S’
Number ::= [’+’ | ’-’] Digit [’.’ Digit]
String ::= ”’ . ”’
Name ::= ’a’ | ... | ’z’
Digit ::= ’0’ | ... | ’9’
