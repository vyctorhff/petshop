
export const createDto = (data: Record<string, string>): FindDTO => {
  return new FindDTO(
    parseInt(data['id']),
    data['name'],
  );
}

export class FindDTO {

  constructor(public id: number, public name: string) {}

  hasId(): boolean {
    return Boolean(this.id);
  }

  hasName(): boolean {
    return Boolean(this.name);
  }
}
