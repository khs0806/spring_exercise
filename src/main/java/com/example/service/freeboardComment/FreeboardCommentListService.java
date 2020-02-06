package com.example.service.freeboardComment;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.FreeboardComment;
import com.example.repository.FreeboardCommentRepository;

@Service
public class FreeboardCommentListService {
	
	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;
	
	public List<FreeboardComment> getList(Long freeId){
		
		List<FreeboardComment> freeboardCommentList = freeboardCommentRepository.findAllByFreeId(freeId);
		
		LinkedList<FreeboardComment> CommentLinkedList = new LinkedList<FreeboardComment>();
		
		for (int i = 0; i < CommentLinkedList.size(); i++) {
            if (freeboardCommentList.get(i).getCommentLevel()==0) {//���� 0 ��۵� ���� ���Ḯ��Ʈ�� �����Ѵ�.
                CommentLinkedList.add(freeboardCommentList.get(i));//1���� �߰��Ѵ�.
            }
        }
        
        for (int i = 0; i < freeboardCommentList.size(); i++) {//��� ��ü�� ���鼭
            if (freeboardCommentList.get(i).getCommentLevel() != 0) {//���� ������ 0�� �ƴѰ͵��� �Ÿ�
                //0�� �ƴ� �͵��� �ɷ���. -> ��ۿ� �޸� ��۵��� �ǹ��Ѵ�.
                Long origin_id = freeboardCommentList.get(i).getCommentOriginId();
                for (int j = 0; j < CommentLinkedList.size(); j++) {
                    if (CommentLinkedList.get(j).getCommentOriginId() == origin_id) {
                        CommentLinkedList.add(j+1, freeboardCommentList.get(i));
                    }
                }
            }             
        }

    return freeboardCommentList;
	
	
	
	}
}
