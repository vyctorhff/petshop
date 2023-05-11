import { Injectable, UnauthorizedException } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import { TokenRequestDTO } from './dtos/token.request.dto';
import { TokenResponseDTO } from './dtos/token.response.dto';
import { UserExternalService } from 'src/external-api/user-external.service';

@Injectable()
export class AuthorizationService {
  constructor(
    private readonly jwtService: JwtService,
    private readonly userExternalService: UserExternalService,
  ) {}

  async getToken(tokenRequest: TokenRequestDTO): Promise<TokenResponseDTO> {
    const user = await this.userExternalService.getUserByEnrollmentAndPass(
      tokenRequest.enrollment,
      tokenRequest.pass,
    );

    if (!user) {
      throw new UnauthorizedException('invalid credentions');
    }

    // TODO: create payload
    const payload = {
      perfils: [],
      userId: '',
      userName: '',
    };

    const token = await this.jwtService.signAsync(payload);

    const result: TokenResponseDTO = {
      time: new Date(),
      token,
      refresh: 'not implemented',
    };

    return result;
  }
}
