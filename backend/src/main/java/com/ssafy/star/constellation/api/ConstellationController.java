package com.ssafy.star.constellation.api;

import com.ssafy.star.article.application.ArticleService;
import com.ssafy.star.common.response.Response;
import com.ssafy.star.constellation.application.ConstellationService;
import com.ssafy.star.constellation.dto.Constellation;
import com.ssafy.star.constellation.dto.request.ConstellationCreateRequest;
import com.ssafy.star.constellation.dto.request.ConstellationModifyRequest;
import com.ssafy.star.constellation.dto.response.ConstellationForUserResponse;
import com.ssafy.star.constellation.dto.response.ConstellationResponse;
import com.ssafy.star.constellation.dto.response.ConstellationWithArticleResponse;
import com.ssafy.star.contour.dto.Contour;
import com.ssafy.star.user.application.FollowService;
import com.ssafy.star.user.dto.request.NicknameRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ConstellationController {
    private final ConstellationService constellationService;
    private final ArticleService articleService;
    private final FollowService followService;

    @Operation(
            summary = "별자리 생성",
            description = "별자리 생성입니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "생성 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @PostMapping("/constellations")
    public Response<Void> create(
            Authentication authentication,
            @RequestPart("request") ConstellationCreateRequest request,
            @RequestPart("origin") MultipartFile origin,
            @RequestPart("thumb") MultipartFile thumb,
            @RequestPart("cthumb") MultipartFile cthumb,
            @RequestPart("contoursList") List<List<List<Integer>>> contoursList,
            @RequestPart("ultimate") List<List<Integer>> ultimate
    ) throws IOException {
        log.info("contoursList : {} contoursList : {}", contoursList, ultimate);
        // 사용자를 관리자로 만듦
        constellationService.create(
                authentication.getName(),
                request.name(),
                request.description(),
                origin,
                thumb,
                cthumb,
                contoursList,
                ultimate
        );
        return Response.success();
    }

    @Operation(
            summary = "별자리 수정",
            description = "별자리 수정입니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "수정 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @PutMapping("/constellations/{constellationId}")
    public Response<ConstellationResponse> modify(
            Authentication authentication,
            @PathVariable Long constellationId,
            @RequestPart("request") ConstellationModifyRequest request,
            @RequestPart("origin") MultipartFile origin,
            @RequestPart("thumb") MultipartFile thumb,
            @RequestPart("cthumb") MultipartFile cthumb,
            @RequestPart("contoursList") List<List<List<Integer>>> contoursList,
            @RequestPart("ultimate") List<List<Integer>> ultimate
    ) throws IOException {
        Constellation constellation = constellationService.modify(
                authentication.getName(),
                constellationId,
                request.name(),
                request.description(),
                origin,
                thumb,
                cthumb,
                contoursList,
                ultimate
        );
        return Response.success(ConstellationResponse.fromConstellation(constellation));
    }

    @Operation(
            summary = "별자리 삭제",
            description = "별자리 삭제입니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "삭제 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @DeleteMapping("/constellations/{constellationId}")
    public Response<Void> deleteConstellationWithContour(Authentication authentication, @PathVariable Long constellationId) {
        constellationService.deleteConstellationWithContour(authentication.getName(), constellationId);
        return Response.success();
    }

    @Operation(
            summary = "나의 우주 보기 - 별자리 전체 조회",
            description = "별자리 전체 조회입니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @GetMapping("/constellations")
    public Response<List<ConstellationWithArticleResponse>> myConstellations(Authentication authentication) {
        return Response.success(constellationService.myConstellations(authentication.getName()).stream().map(ConstellationWithArticleResponse::fromConstellationWithArticle).toList());
    }

    @Operation(
            summary = "유저의 별자리 전체 조회",
            description = "유저의 별자리 전체 조회입니다."
    )
    @GetMapping("/constellations/user/{nickname}")
    public Response<List<ConstellationWithArticleResponse>> userConstellations(Authentication authentication, @PathVariable String nickname) {
        return Response.success(
                constellationService.userConstellations(authentication.getName(), nickname)
                        .stream()
                        .map(ConstellationWithArticleResponse::fromConstellationWithArticle)
                        .toList()
        );
    }

    @Operation(
            summary = "별자리 윤곽선 수정 요청을 보내면 현재 윤곽선 정보를 반환",
            description = "관련 이미지 3장, 윤곽선 리스트, 현재 선택되어 있는 윤곽선 반환",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @PostMapping("/constellations/{constellationId}/request-contour")
    public Response<Contour> requestModifyConstellation(Authentication authentication, @PathVariable Long constellationId) {
        return Response.success(constellationService.requestModifyConstellation(authentication.getName(), constellationId));
    }

    // TODO : 별자리 공유 신청, 수락 로직으로 바꿀 것
    @Operation(
            summary = "공유 별자리에 유저 추가",
            description = "공유 별자리에 유저를 추가합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "추가 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @PostMapping("/add-user/constellations/{constellationId}")
    public Response<Void> addUser(Authentication authentication, @PathVariable Long constellationId, @RequestBody NicknameRequest nicknameRequest) {
        String nickname = nicknameRequest.nickname();
        constellationService.addUser(constellationId, nickname, authentication.getName());
        return Response.success();
    }

    @Operation(
            summary = "공유 별자리의 유저 삭제",
            description = "공유 별자리의 유저를 삭제합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "삭제 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @DeleteMapping("/delete-user/constellations/{constellationId}")
    public Response<Void> deleteUser(Authentication authentication, @PathVariable Long constellationId, @RequestBody NicknameRequest nicknameRequest) {
        String nickname = nicknameRequest.nickname();
        constellationService.deleteUser(constellationId, nickname, authentication.getName());
        return Response.success();
    }

    @Operation(
            summary = "공유 별자리의 유저 조회",
            description = "공유 별자리의 유저를 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @GetMapping("/users/constellations/{constellationId}")
    public Response<List<ConstellationForUserResponse>> userCheck(@PathVariable Long constellationId, Authentication authentication, Pageable pageable) {
        return Response.success(constellationService.findConstellationUsers(constellationId));
    }

    @Operation(
            summary = "공유 별자리의 관리자 변경",
            description = "공유 별자리의 관리자를 변경합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "수정 성공", content = @Content(schema = @Schema(implementation = ConstellationResponse.class)))
            }
    )
    @PutMapping("/role-modify/constellations/{constellationId}")
    public Response<Void> roleModify(@PathVariable Long constellationId, @RequestBody NicknameRequest request, Authentication authentication) {
        String nickname = request.nickname();
        constellationService.roleModify(constellationId, nickname, authentication.getName());
        return Response.success();
    }
}
