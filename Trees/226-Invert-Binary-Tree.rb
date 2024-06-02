# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @return {TreeNode}
def invert_tree(root)

    if !root
        return nil
    end

    if root.left || root.right
        tmp = root.left
        root.left = invert_tree(root.right)
        root.right = invert_tree(tmp)
    end

    return root;
    
end