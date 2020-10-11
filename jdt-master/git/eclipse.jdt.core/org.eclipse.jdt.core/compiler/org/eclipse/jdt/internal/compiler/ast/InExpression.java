package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class InExpression extends OperatorExpression{
    public Expression left;
    public Expression right;


    public InExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        right.bits |= IgnoreRawTypeCheck;
        this.bits |= INSTANCEOF << OperatorSHIFT;
        this.sourceStart = left.sourceStart;
        this.sourceEnd = right.sourceEnd;
    }

    @Override
    public StringBuffer printExpressionNoParenthesis(int indent, StringBuffer output) {
        this.left.printExpression(indent, output).append(" in "); //$NON-NLS-1$
        return this.right.print(0, output);
    }

    @Override
    public void traverse(ASTVisitor visitor, BlockScope scope) {
        if (visitor.visit(this, scope)) {
            this.left.traverse(visitor, scope);
            this.right.traverse(visitor, scope);

        }
        visitor.endVisit(this, scope);
    }
}