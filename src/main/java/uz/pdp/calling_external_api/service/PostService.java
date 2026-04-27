package uz.pdp.calling_external_api.service;

import uz.pdp.calling_external_api.payload.PostCreator;
import uz.pdp.calling_external_api.payload.PostResponse;
import uz.pdp.calling_external_api.payload.PostResponseWithComments;

public interface PostService {
    PostResponse create(PostCreator creator);

    PostResponse findById(Integer id);

    PostResponseWithComments findByIdWithComments(Integer id);
}
