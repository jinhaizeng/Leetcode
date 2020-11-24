/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* dummyNode = new ListNode();
        ListNode* topNode = dummyNode;
        while (l1 != nullptr && l2 != nullptr) {
            if (l1->val <= l2->val) {
                topNode->next = l1;
                l1 = l1->next;
            } else {
                topNode->next = l2;
                l2 = l2->next;
            }

            topNode = topNode->next;
        }

        if (l1 == nullptr) {
            topNode->next = l2;
        } else {
            topNode->next = l1;
        }
        return dummyNode->next;
    }
};