package org.eclipse.jdt.core.dom;

import org.eclipse.jdt.internal.compiler.ast.InExpression;
import org.eclipse.jdt.internal.core.dom.util.DOMASTUtil;

import java.util.ArrayList;
import java.util.List;

public class PyInExpression extends Expression{
    /**
     * Creates a new AST node for an expression owned by the given AST.
     * <p>
     * N.B. This constructor is package-private.
     * </p>
     *
     * @param ast the AST that is to own this node
     */
    public static final ChildPropertyDescriptor LEFT_OPERAND_PROPERTY =
            new ChildPropertyDescriptor(PyInExpression.class, "leftOperand", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    /**
     * The "rightOperand" structural property of this node type (child type: {@link Type}).
     * @since 3.0
     */
    public static final ChildPropertyDescriptor RIGHT_OPERAND_PROPERTY =
            new ChildPropertyDescriptor(PyInExpression.class, "rightOperand", Type.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

    public static final ChildPropertyDescriptor PATTERN_VARIABLE_PROPERTY =
            new ChildPropertyDescriptor(PyInExpression.class, "patternVariable", SingleVariableDeclaration.class, OPTIONAL, NO_CYCLE_RISK); //$NON-NLS-1$

    private static final List PROPERTY_DESCRIPTORS;
    private static final List PROPERTY_DESCRIPTORS_14;

    static {
        List properyList = new ArrayList(3);
        createPropertyList(PyInExpression.class, properyList);
        addProperty(LEFT_OPERAND_PROPERTY, properyList);
        addProperty(RIGHT_OPERAND_PROPERTY, properyList);
        PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
        properyList = new ArrayList(4);
        createPropertyList(PyInExpression.class, properyList);
        addProperty(LEFT_OPERAND_PROPERTY, properyList);
        addProperty(RIGHT_OPERAND_PROPERTY, properyList);
        addProperty(PATTERN_VARIABLE_PROPERTY, properyList);
        PROPERTY_DESCRIPTORS_14 = reapPropertyList(properyList);
    }

    private Expression leftOperand = null;

    private Expression rightOperand = null;

    public static List propertyDescriptors(int apiLevel) {
        return propertyDescriptors(apiLevel, false);
    }


    public static List propertyDescriptors(int apiLevel, boolean previewEnabled) {
        return PROPERTY_DESCRIPTORS;
    }

    PyInExpression(AST ast) {
        super(ast);
    }

    int getNodeType0() {
       return PY_IN_EXPRESSION;
    }

    boolean subtreeMatch0(ASTMatcher matcher, Object other) {
        return matcher.match(this, other);
    }

    ASTNode clone0(AST target) {
        PyInExpression result = new PyInExpression(target);
        result.setSourceRange(getStartPosition(), getLength());
        result.setLeftOperand((Expression) getLeftOperand().clone(target));
        result.setRightOperand((Expression) getRightOperand().clone(target));
        return result;
    }

    void accept0(ASTVisitor visitor) {
        boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            // visit children in normal left to right reading order
            acceptChild(visitor, getLeftOperand());
            acceptChild(visitor, getRightOperand());
        }
        visitor.endVisit(this);
    }

    int treeSize() {
        return
                memSize()
                        + (this.leftOperand == null ? 0 : getLeftOperand().treeSize())
                        + (this.rightOperand == null ? 0 : getRightOperand().treeSize());

    }

    int memSize() {
        return BASE_NODE_SIZE + 3 * 4;
    }

    public Expression getLeftOperand() {
        if (this.leftOperand  == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.leftOperand == null) {
                    preLazyInit();
                    this.leftOperand= new SimpleName(this.ast);
                    postLazyInit(this.leftOperand, LEFT_OPERAND_PROPERTY);
                }
            }
        }
        return this.leftOperand;
    }

    public void setLeftOperand(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.leftOperand;
        preReplaceChild(oldChild, expression, LEFT_OPERAND_PROPERTY);
        this.leftOperand = expression;
        postReplaceChild(oldChild, expression, LEFT_OPERAND_PROPERTY);
    }

    public void setRightOperand(Expression expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        ASTNode oldChild = this.rightOperand;
        preReplaceChild(oldChild, expression, RIGHT_OPERAND_PROPERTY);
        this.rightOperand = expression;
        postReplaceChild(oldChild, expression, RIGHT_OPERAND_PROPERTY);
    }

    public Expression getRightOperand() {
        if (this.rightOperand  == null) {
            // lazy init must be thread-safe for readers
            synchronized (this) {
                if (this.rightOperand == null) {
                    preLazyInit();
                    this.rightOperand= new SimpleName(this.ast);
                    postLazyInit(this.rightOperand, RIGHT_OPERAND_PROPERTY);
                }
            }
        }
        return this.rightOperand;
    }

    @Override
    final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
        if (property == LEFT_OPERAND_PROPERTY) {
            if (get) {
                return getLeftOperand();
            } else {
                setLeftOperand((Expression) child);
                return null;
            }
        }
        if (property == RIGHT_OPERAND_PROPERTY) {
            if (get) {
                return getRightOperand();
            } else {
                setRightOperand((Expression)child);
                return null;
            }
        }
        // allow default implementation to flag the error
        return super.internalGetSetChildProperty(property, get, child);
    }

    @Override
    final List internalStructuralPropertiesForType(int apiLevel) {
        return propertyDescriptors(apiLevel);
    }

    @Override
    final List internalStructuralPropertiesForType(int apiLevel, boolean previewEnabled) {
        return propertyDescriptors(apiLevel, previewEnabled);
    }
}
